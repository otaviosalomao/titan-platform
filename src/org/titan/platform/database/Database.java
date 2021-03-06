/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.database;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Database {

    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static String URL = "jdbc:postgresql:";

    static {
        try {
            Class.forName(DRIVER_NAME).newInstance();
        } catch (Exception e) {
        }

    }
    private static String INSTRUCTIONS = new String();

    public static Connection getConnection(String database, String user, String password) throws SQLException {
         return DriverManager.getConnection(URL+database, user, password);
    }



    public static void resetDatabase(String user, String password, InputStream stream, Connection connection) throws SQLException, FileNotFoundException, IOException {
        String s = new String();
        StringBuilder sb = new StringBuilder();

       Scanner sc = new Scanner(stream, "ISO-8859-1");

        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String[] inst = sb.toString().split(";");

        Statement st = connection.createStatement();

        for (int i = 0; i < inst.length; i++) {
            if (!inst[i].trim().equals("")) {
                st.executeUpdate(inst[i]);
            }
        }


    }
}
