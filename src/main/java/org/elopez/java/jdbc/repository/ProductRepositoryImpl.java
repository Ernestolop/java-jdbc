package org.elopez.java.jdbc.repository;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.elopez.java.jdbc.models.Product;
import org.elopez.java.jdbc.util.DatabaseConnection;

public class ProductRepositoryImpl implements Repository<Product> {
    
    private Connection getConnection() throws SQLException{
        return DatabaseConnection.getConnection();
    }
    
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try (
            Statement stmt = getConnection().createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM products");
        ) {
            while (resultSet.next()) {
                Product product = loadProduct(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product findById(Long id) {
        Product product = new Product();

        try (
            PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM products WHERE id = ?");
        ) {
            pstmt.setLong(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                product = loadProduct(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void save(Product entity) {
        try (
            PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)");
        ) {
            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product entity) {
        try (
            PreparedStatement pstmt = getConnection().prepareStatement("UPDATE products SET name = ?, price = ? WHERE id = ?");
        ) {
            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getPrice());
            pstmt.setLong(3, entity.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product entity) {
        try (
            PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM products WHERE id = ?");
        ) {
            pstmt.setLong(1, entity.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product loadProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setCreationDate(resultSet.getDate("creation_date"));
        return product;
    }
    
}
