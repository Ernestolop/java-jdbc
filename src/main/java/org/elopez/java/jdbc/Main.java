package org.elopez.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.elopez.java.jdbc.repository.Repository;
import org.elopez.java.jdbc.util.DatabaseConnection;
import org.elopez.java.jdbc.models.Product;
import org.elopez.java.jdbc.repository.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        try(Connection connection = DatabaseConnection.getConnection();) {
            Repository<Product> productRepository = new ProductRepositoryImpl();
            productRepository.findAll().forEach(System.out::println);
            System.out.println(productRepository.findById(1L));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
