package com.costin.springhbpractice;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class TestApp
{
    public static void main( String[] args ) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false&serverTimezone=UTC";
        String user = "costin";
        String pass = "costin";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConnection =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!!!!");

            myConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
