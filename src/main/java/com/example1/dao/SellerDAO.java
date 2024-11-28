package com.example1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SellerDAO
{
    private Connection connection;
    public SellerDAO(Connection connection)
    {
        this.connection = connection;
    }
    public void getAllSellers()
    {
        String query = "SELECT * FROM Sellers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query))
        {
            System.out.println("Sellers:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("SellerID") +
                        ", Name: " + rs.getString("SellerName") +
                        ", Phone: " + rs.getString("Phone") +
                        ", Email: " + rs.getString("Email"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}