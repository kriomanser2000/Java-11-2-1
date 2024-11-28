package com.example1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection
{
    private static Connection connection;
    public static Connection connect()
    {
        if (connection == null)
        {
            try
            {
                Properties props = new Properties();
                props.load(DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties"));
                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");
                String driver = props.getProperty("db.driver");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to the database was successful!");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void disconnect()
    {
        try
        {
            if (connection != null)
            {
                connection.close();
                System.out.println("Disconnected from the database!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
