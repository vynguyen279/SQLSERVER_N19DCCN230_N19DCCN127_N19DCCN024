/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author VyNguyen
 */
public class SQLConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433; databaseName=QLKS;";
            String username = "sa";
            String pw = "270901";
            con = DriverManager.getConnection(connectionUrl, username, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
