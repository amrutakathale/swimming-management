package com.swim.scm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        String url = "jdbc:mysql://switchback.proxy.rlwy.net:42481/railway";
        String user = "root";
        String password = "dnxKFNUUKByZVYaTMSxpoWpBdBEtehAI";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Railway DB successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}