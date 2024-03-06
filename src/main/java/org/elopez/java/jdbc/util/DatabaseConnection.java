package org.elopez.java.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static String url = "jdbc:postgresql://localhost:5432/jdbc_test";
    private static String user = "postgres";
    private static String password = "1234";
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
