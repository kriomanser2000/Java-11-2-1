package com.example1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductDAO
{
    private Connection connection;
    public ProductDAO(Connection connection)
    {
        this.connection = connection;
    }
    public void getAllProducts()
    {
        String query = "SELECT SaleID, ProductName, SalePrice, SaleDate FROM Sales";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query))
        {
            System.out.println("Products:");
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("SaleID") +
                        ", Product: " + rs.getString("ProductName") +
                        ", Price: " + rs.getDouble("SalePrice") +
                        ", Date: " + rs.getDate("SaleDate"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}