package org.web.boardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CleanUpGang {
    private CleanUpGang() {}
    private static class singleton {
        private static final CleanUpGang instance = new CleanUpGang();
    }
    public static CleanUpGang getCleaned() {
        return singleton.instance;
    }

    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public void cleanGang() {
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
}
