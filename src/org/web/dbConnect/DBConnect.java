package org.web.dbConnect;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection() {
        Connection conn = null;
//        String url = "jdbc:mysql://localhost:3306/webprojects?allowPublicKeyRetrieval=true&useSSL=false&amp&useUnicode=true&amp&serverTimezone=UTC";
//        String hostId = "root";
//        String hostPw = "12345678";
//        String driver = "com.mysql.cj.jdbc.Driver";

        DataSource dataSource;

        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, hostId, hostPw);
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/db");
            conn = ds.getConnection();

            System.out.println("db connected");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
