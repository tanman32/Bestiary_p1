package util;

import models.Entry;
import repos.EntryImplementation;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;


public class JDBCConnection {

    private static Connection conn = null;

    //private static EntryImplementation BestiaryConn = new EntryImplementation();

    public static Connection getConnection() {

    /*
        To establish a new connection if one doesn't exist,
        otherwise return the current connection.

        Credentials: url (endpoint), username, password
         */

        if (conn == null) {
            //Establish a new Connection

            Properties props = new Properties();
            try {

                Class.forName("org.postgresql.Driver");

                props.load(JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties"));
//                props.load(new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile()));
//                props.load(new FileReader("src/main/resources/connection.properties"));

                String endpoint = props.getProperty("endpoint");
                //URL Format (Postgresql JDBC)
                //jdbc:postgresql://[endpoint]/[database]
                String url = "jdbc:postgresql://" + endpoint + "/Bestiary";
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(url, username, password);

            } catch (IOException | SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("hippo!");
        return conn;
    }


    /*
    THIS IS FOR TESTING PURPOSES ONLY!!!!!!!!!!!!!!
    NOT NEEDED TO ACTUALLY USE JDBC
     */
    public static void main(String[] args) {

        EntryImplementation BestiaryConn = new EntryImplementation();
        LinkedList<Entry> Bestiary = BestiaryConn.getEntries();


        for (Entry e: Bestiary
        ) {
            System.out.print(e.getName() + "\t Type:" + e.getType() + "\t Banned Status:" + e.isBanned()  + "\nStats:\n"
                    + e.getPower()  + "\t" + e.getEndurance()  + "\t" + e.getSpeed()  + "\t" + e.getFlight() + "\n" +
                    e.getConstitution()  + "\t" + e.getDiscipline()  + "\t" + e.getResistance()  + "\t" +  e.getIntelligence() + "\n");
        }

    }


}
