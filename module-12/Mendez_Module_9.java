//Cameron Mendez
//12/21/2025
//Module-9

package com.mycompany.module_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Module_9 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/databasedb";
        String user = "student1";
        String password = "pass";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}