package org.web.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/webprojects?useSSL=false&amp&useUnicode=true&amp&serverTimezone=UTC";
        String hostId = "root";
        String hostPw = "12345678";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, hostId, hostPw);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
