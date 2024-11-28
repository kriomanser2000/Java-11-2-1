package com.example1;

import com.example1.dao.SaleDAO;
import com.example1.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        Connection connection = DatabaseConnection.connect();
        if (connection != null)
        {
            SaleDAO saleDAO = new SaleDAO(connection);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option:");
            System.out.println("1. Add Sale");
            System.out.println("2. Delete Sale");
            System.out.println("3. Update Sale");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1 ->
                {
                    System.out.println("Enter product name:");
                    String productName = scanner.nextLine();
                    System.out.println("Enter sale price:");
                    double salePrice = scanner.nextDouble();
                    System.out.println("Enter sale date (YYYY-MM-DD):");
                    Date saleDate = Date.valueOf(scanner.next());
                    System.out.println("Enter seller ID:");
                    int sellerID = scanner.nextInt();
                    System.out.println("Enter buyer ID:");
                    int buyerID = scanner.nextInt();
                    saleDAO.addSale(productName, salePrice, saleDate, sellerID, buyerID);
                }
                case 2 ->
                {
                    System.out.println("Enter Sale ID to delete:");
                    int saleID = scanner.nextInt();
                    saleDAO.deleteSale(saleID);
                }
                case 3 ->
                {
                    System.out.println("Enter Sale ID to update:");
                    int saleID = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    System.out.println("Enter new product name:");
                    String newProductName = scanner.nextLine();
                    System.out.println("Enter new sale price:");
                    double newSalePrice = scanner.nextDouble();
                    System.out.println("Enter new sale date (YYYY-MM-DD):");
                    Date newSaleDate = Date.valueOf(scanner.next());
                    saleDAO.updateSale(saleID, newProductName, newSalePrice, newSaleDate);
                }
                default -> System.out.println("Invalid choice.");
            }
            scanner.close();
            DatabaseConnection.disconnect();
        }
    }
}