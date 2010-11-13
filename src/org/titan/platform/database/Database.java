/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.database;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Database {

    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static String URL = "jdbc:postgresql:postgres";

    static {
        try {
            Class.forName(DRIVER_NAME).newInstance();
        } catch (Exception e) {
        }

    }
    private static String INSTRUCTIONS = new String();

    public static Connection getConnection(String user, String password) throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }


    public static void resetDatabase(String user, String password, File sqlFile) throws SQLException, FileNotFoundException, IOException {
        String s = new String();
        StringBuilder sb = new StringBuilder();

        FileReader fr = new FileReader(sqlFile);

        BufferedReader br = new BufferedReader(fr);

        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        br.close();

        String[] inst = sb.toString().split(";");

        Connection c = Database.getConnection(user, password);
        Statement st = c.createStatement();

        for (int i = 0; i < inst.length; i++) {
            if (!inst[i].trim().equals("")) {
                st.executeUpdate(inst[i]);
            }
        }


    }
}
