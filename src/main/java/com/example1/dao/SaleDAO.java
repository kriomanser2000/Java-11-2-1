package com.example1.dao;

import java.sql.*;

public class SaleDAO
{
    private Connection connection;
    public SaleDAO(Connection connection)
    {
        this.connection = connection;
    }
    public void addSale(String productName, double salePrice, Date saleDate, int sellerID, int buyerID)
    {
        String query = """
                INSERT INTO Sales (ProductName, SalePrice, SaleDate, SellerID, BuyerID)
                VALUES (?, ?, ?, ?, ?)
                """;
        try (PreparedStatement pstmt = connection.prepareStatement(query))
        {
            pstmt.setString(1, productName);
            pstmt.setDouble(2, salePrice);
            pstmt.setDate(3, saleDate);
            pstmt.setInt(4, sellerID);
            pstmt.setInt(5, buyerID);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteSale(int saleID)
    {
        String query = "DELETE FROM Sales WHERE SaleID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query))
        {
            pstmt.setInt(1, saleID);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updateSale(int saleID, String newProductName, double newSalePrice, Date newSaleDate)
    {
        String query = """
                UPDATE Sales
                SET ProductName = ?, SalePrice = ?, SaleDate = ?
                WHERE SaleID = ?
                """;
        try (PreparedStatement pstmt = connection.prepareStatement(query))
        {
            pstmt.setString(1, newProductName);
            pstmt.setDouble(2, newSalePrice);
            pstmt.setDate(3, newSaleDate);
            pstmt.setInt(4, saleID);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}