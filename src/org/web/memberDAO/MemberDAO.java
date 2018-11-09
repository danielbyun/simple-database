package org.web.memberDAO;

import org.web.dbConnect.DBConnect;

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

    private static class singleton {
        private static final MemberDAO instance = new MemberDAO();
    }

    public static MemberDAO getInstance() {
        return singleton.instance;
    }

    // i put the last method in a method to make the code DRY
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
        String query = "";

        try {
            conn = DBConnect.getConnection();
            query = "select count(*) from simpleDatabase.members where userId = ?";
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
        String query = "";

        try {
            conn = DBConnect.getConnection();
            query = "insert into simpleDatabase.members (userId, userPw, userEmail) values (?, ?, ?)";
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

    public int memberLogin(String userId, String userPw) {
        int result = 0;
        String query = "";

         try {
             conn = DBConnect.getConnection();
             query = "select count(*) from simpleDatabase.members where userId=? and userPw=?";
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
}
