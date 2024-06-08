package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyApp {
    public static void main(String[] args) {
        String jdbcUrl = System.getenv("JDBC_URL");
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 1");

            while (resultSet.next()) {
                System.out.println("Query Result: " + resultSet.getInt(1));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Keep the application running
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
