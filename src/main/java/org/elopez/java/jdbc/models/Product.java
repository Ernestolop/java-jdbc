package org.elopez.java.jdbc.models;

import java.sql.Date;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Date creationDate;

    public Product() {
    }

    public Product(Long id, String name, Double price, Date creationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "{id:" + id + ", name:" + name + ", price:" + price + ", creationDate:" + creationDate + "}";
    }
}
