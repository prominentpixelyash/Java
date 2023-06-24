package com.prominentpixel.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionClass {

    public Connection getConnection(){

        Connection connection=null;

        try {
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/shows","postgres","admin");
            System.out.println("Connected with Postgres Database");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
