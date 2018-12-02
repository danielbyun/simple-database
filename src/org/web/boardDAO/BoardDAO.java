package org.web.boardDAO;

import org.web.boardDTO.BoardDTO;
import org.web.dbConnect.DBConnect;

import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    private BoardDAO() {
    }

    public static BoardDAO getInstance() {
        return singleton.instance;
    }

    private void cleanUp() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // list all boards method
    public ArrayList<BoardDTO> list() {
        ArrayList<BoardDTO> lists = new ArrayList<>();

        try {
            conn = DBConnect.getConnection();
            String query = "select * from simpleDatabase.posts order by hit desc, mGroup asc, indent asc";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int mId = rs.getInt(1);
                    int mGroup = rs.getInt(2);
                    int mIndent = rs.getInt(3);
                    int step = rs.getInt(4);
                    int hit = rs.getInt(5);
                    String userId = rs.getString(6);
                    String title = rs.getString(7);
                    String content = rs.getString(8);
                    Timestamp date = rs.getTimestamp(9);

                    BoardDTO dto = new BoardDTO(mId, mGroup, mIndent, step, hit, userId, title, content, date);
                    lists.add(dto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return lists;
    }

    public int write(String userId, String title, String content) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "insert into simpleDatabase.posts(mGroup, step, hit, indent, userId, title, content, date) values ((select case count(*) when 0 then 1 else max(mGroup) + 1 end from simpleDatabase.posts b1), 0, 0, 0, ?, ?, ?, now())";
            pstm = conn.prepareStatement(query);

            pstm.setString(1, userId);
            pstm.setString(2, title);
            pstm.setString(3, content);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    public BoardDTO boardView(int mId) {
        BoardDTO dto = null;

        upHit(mId);

        try {
            conn = DBConnect.getConnection();
            String query = "select * from simpleDatabase.posts where mId=?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, mId);

            rs = pstm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int mId1 = rs.getInt(1);
                    int mGroup = rs.getInt(2);
                    int step = rs.getInt(3);
                    int hit = rs.getInt(4);
                    int indent = rs.getInt(5);
                    String userId = rs.getString(6);
                    String title = rs.getString(7);
                    String content = rs.getString(8);
                    Timestamp date = rs.getTimestamp(9);

                    dto = new BoardDTO(mId1, mGroup, step, hit, indent, userId, title, content, date);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return dto;
    }

    public int update(int mId, String userId, String content) {
        int result = 0;

        return result;
    }

    public int boardReply(int mId, int mGroup, int step, int indent, String userId, String title, String content) {
        int result = 0;

        boardReplyUpdate(mGroup, step);

        try {
            conn = DBConnect.getConnection();
            String query = "insert into simpleDatabase.posts(mId, mGroup, step, indent, userId, title, content, date) VALUES (null, ?, ?, ?, ?, ?, ?, now())";
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, mGroup);
            pstm.setInt(2, step + 1);
            pstm.setInt(3, indent + 1);
            // for prepending 're:' on replies
            // somehow add re: depending on the result of (indent + 1)?
            pstm.setString(4, userId);
            pstm.setString(5, title);
            pstm.setString(6, content);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    private int upHit(int mId) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "update simpleDatabase.posts set hit = hit + 1 where mId = ?";

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, mId);
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    private int boardReplyUpdate(int mGroup, int step) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "update simpleDatabase.posts set step = step + 1 where mGroup = ? and step > ?";
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, mGroup);
            pstm.setInt(2, step);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    public int commentCount(int mGroup) {
        int count = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "select count(*) from simpleDatabase.posts where mGroup = ?";
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, mGroup);

            rs = pstm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return count;
    }

    public int boardUpdate(int mId, String title, String content) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "update simpleDatabase.posts set title = ?, content = ? where mId = ?";
            pstm = conn.prepareStatement(query);

            pstm.setString(1, title);
            pstm.setString(2, content);
            pstm.setInt(3, mId);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    private static class singleton {
        private static final BoardDAO instance = new BoardDAO();
    }
}
