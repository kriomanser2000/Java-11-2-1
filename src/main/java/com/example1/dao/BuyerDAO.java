package com.example1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BuyerDAO
{
    private Connection connection;
    public BuyerDAO(Connection connection)
    {
        this.connection = connection;
    }
    public void getAllBuyers()
    {
        String query = "SELECT * FROM Buyers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query))
        {
            System.out.println("Buyers:");
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("BuyerID") +
                        ", Name: " + rs.getString("BuyerName") +
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