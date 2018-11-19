package org.web.boardDAO;

import org.web.boardDTO.BoardDTO;
import org.web.dbConnect.DBConnect;

import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {
    private CleanUpGang clean = CleanUpGang.getCleaned();
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    private BoardDAO() {
    }

    public static BoardDAO getInstance() {
        return singleton.instance;
    }

    // list all boards method
    public ArrayList<BoardDTO> list() {
        ArrayList<BoardDTO> lists = new ArrayList<>();

        try {
            conn = DBConnect.getConnection();
            String query = "select * from simpleDatabase.posts";
            pstm = conn.prepareStatement(query);

            rs = pstm.executeQuery();

            if (rs != null) {
                while(rs.next()) {
                    int mId = rs.getInt(1);
                    int mGroup = rs.getInt(2);
                    int mIndent = rs.getInt(3);
                    int step = rs.getInt(4);
                    int hit = rs.getInt(5);
                    String userName = rs.getString(6);
                    String title = rs.getString(7);
                    String content = rs.getString(8);
                    Timestamp date = rs.getTimestamp(9);

                    BoardDTO dto = new BoardDTO(mId, mGroup, mIndent, step, hit, userName, title, content, date);
                    lists.add(dto);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clean.cleanGang();
        }

        return lists;
    }

    public int write(String nickname, String title, String memo) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "insert into webprojects.paginationBoard1112 (mGroup, step, hit, indent, nickname, title, memo, date) values ((select case count(*) when 0 then 1 else max(mGroup) + 1 end from webprojects.paginationBoard1112 b1), 0, 0, 0, ?, ?, ?, now())";
            pstm = conn.prepareStatement(query);

            pstm.setString(1, nickname);
            pstm.setString(2, title);
            pstm.setString(3, memo);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clean.cleanGang();
        }

        return result;
    }

    private static class singleton {
        private static final BoardDAO instance = new BoardDAO();
    }
}
