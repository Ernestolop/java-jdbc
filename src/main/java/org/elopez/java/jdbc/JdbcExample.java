package org.elopez.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.elopez.java.jdbc.util.DatabaseConnection;

public class JdbcExample {
    public static void main(String[] args) {

        try(
            Connection connection = DatabaseConnection.getConnection();
        ) {
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
    }
}
