package org.web.memberDAO;

import org.web.dbConnect.DBConnect;
import org.web.memberDTO.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    // singleton method to have MemberDAO be retrieved without starting a new instantiation every time
    private MemberDAO() {
    }

    public static MemberDAO getInstance() {
        return singleton.instance;
    }

    //  i put the last method in a method to make the code DRY
    private void cleanUp() {
        try {
            if (conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // id validation method
    public int idCheck(String userId) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "select count(*) from simpleDatabase.members where userId = ?";
            pstm = conn.prepareStatement(query);

            pstm.setString(1, userId);
            rs = pstm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    // join method
    public int memberJoin(String userId, String userPw, String userEmail) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "insert into simpleDatabase.members (id, userId, userPw, userEmail) values (null, ?, ?, ?)";
            pstm = conn.prepareStatement(query);

            pstm.setString(1, userId);
            pstm.setString(2, userPw);
            pstm.setString(3, userEmail);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    public MemberDTO memberLoginAndRetrieveAll(String userId, String userPw) {
        MemberDTO member = null;

        try {
            conn = DBConnect.getConnection();
            String query = "select * from simpleDatabase.members where userId=? and userPw=?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, userId);
            pstm.setString(2, userPw);

            rs = pstm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int memberId = rs.getInt(1);
                    String userId1 = rs.getString(2);
                    String userPw1 = rs.getString(3);
                    String userEmail = rs.getString(4);

                    member = new MemberDTO(memberId, userId1, userPw1, userEmail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }
        return member;
    }

    public int memberLogin(String userId, String userPw) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "select count(*) from simpleDatabase.members where userId=? and userPw=?";
            pstm = conn.prepareStatement(query);

            pstm.setString(1, userId);
            pstm.setString(2, userPw);

            rs = pstm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    public int memberDelete(String userId, String userPw) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "delete from simpleDatabase.members where userId=? and userPw=?";
            pstm = conn.prepareStatement(query);

            pstm.setString(1, userId);
            pstm.setString(2, userPw);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    public MemberDTO memberView(String memberId) {
        MemberDTO member = null;

        try {
            conn = DBConnect.getConnection();
            // String query = "select * from simpleDatabase.members where memberId=?";
            String query = "select * from simpleDatabase.members where id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, memberId);

            rs = pstm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int memberId1 = rs.getInt(1);
                    String userId = rs.getString(2);
                    String userPw = rs.getString(3);
                    String userEmail = rs.getString(4);

                    member = new MemberDTO(memberId1, userId, userPw, userEmail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }
        return member;
    }

    public int memberUpdate(int id, String userId, String userPw, String userEmail) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            String query = "update simpleDatabase.members set userId=?, userPw=?, userEmail=? where id=?";
            pstm = conn.prepareStatement(query);

            pstm.setString(1, userId);
            pstm.setString(2, userPw);
            pstm.setString(3, userEmail);
            pstm.setInt(4, id);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }

        return result;
    }

    private static class singleton {
        private static final MemberDAO instance = new MemberDAO();
    }

}
