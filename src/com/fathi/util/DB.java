package com.fathi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 
 * Data Base Management Class for you to control your data bases with few lines of code
 * @author fathi
 * @version 0.1.2
 */
public class DB {
    
    private static String db_name; 
    private static String user_name;
    private static String user_password;
    
    private static void execute(String query) {
        // try to connect to the database and execute the given query
        Connection con = getConnection(db_name, user_name, user_password);
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Setup your connection and return it so you must define your Connection from "java.sql.Connection" and assign to it.
     * @param db_name: the name of the database you want to connect to
     * @param user_name: server user name
     * @param user_password: server user password
     * @return Connection (from "java.sql.Connection")
     */
    public static Connection getConnection(String db_name, String user_name, String user_password) {
        DB.db_name = db_name;
        DB.user_name = user_name;
        DB.user_password =user_password;
        // string to store the connection information
        String connection = "jdbc:mysql://localhost:3306/" + db_name + "?serverTimezone=UTC&user=" + user_name + "&password=" + user_password;
        // try to connect to the database with the given information
        try {
            Connection con = DriverManager.getConnection(connection);
            return con;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Data from table with "SELECT * FROM ?" query and return it into "ResultSet"
     * @param table: the name of the table you want to take data from
     * @return ResultSet (from "java.sql.ResultSet")
     */
    public static ResultSet getData(String table) {
        // string to store the query
        String query = "SELECT * FROM " + table;
        // try to connect to the database and execute the query
        Connection con = getConnection(db_name, user_name, user_password);
        try {
            return con.createStatement().executeQuery(query);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Data from table with "SELECT ? FROM ?" query and return it into "ResultSet"
     * @param table: the name of the table you want to take data from
     * @param fields: the fields that will be showed from the table
     * @return ResultSet (from "java.sql.ResultSet")
     */
    public static ResultSet getData(String table, String fields) {
        // string to store the query
        String query = "SELECT " + fields + " FROM " + table;
        // try to connect to the database and execute the query
        Connection con = getConnection(db_name, user_name, user_password);
        try {
            return con.createStatement().executeQuery(query);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Data from table with "SELECT ? FROM ? WHERE ?" query and return it into "ResultSet"
     * @param table: the name of the table you want to take data from
     * @param fields: the fields that will be showed from the table
     * @param condition: a condition for the query to filter the data
     * @return ResultSet (from "java.sql.ResultSet")
     */
    public static ResultSet getData(String table, String fields, String condition) {
        // string to store the query
        String query = "SELECT " + fields + " FROM " + table + " WHERE " + condition;
        // try to connect to the database and execute the query
        Connection con = getConnection(db_name, user_name, user_password);
        try {
            return con.createStatement().executeQuery(query);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Insert data into a table with "INSERT INTO..." query
     * @param table: the table to insert into
     * @param fields: the values to be inserted
     */
    public static void insert(String table, Hashtable fields) {
        // variables to store the fields
        int index = 0;
        String input1 = "";
        String input2 = "";
        String[] str = new String[fields.size()];
        Enumeration keys = fields.keys();
        // store the fields in strings one by one
        while(keys.hasMoreElements()) {
            str[index] = (String) keys.nextElement();
            index++;
        }
        // create the body of the query
        for(int i = 0; i < index-1; i++) {
            input1 += str[i] + ", ";
            input2 += "'" + fields.get(str[i]) + "', ";
        }
        input1 += str[index-1];
        input2 += "'" + fields.get(str[index-1]) + "'";
        String query = "INSERT INTO " + table + " (" + input1 + ") VALUES (" + input2 + ")";
        // execute the query
        execute(query);
    }
    
    /**
     * Update data in a table with "UPDATE..." query
     * @param table: the table to update
     * @param values: the values to be inserted
     * @param condition: the condition of the query
     */
    public static void update(String table, String values, String condition) {
        // string to store the query
        String query = "UPDATE " + table + " SET " + values + " WHERE " + condition;
        // execute the query
        execute(query);
    }
    
    /**
     * Delete data from a table with "DELETE FROM..." query
     * @param table: the table to delete the data from
     * @param condition: the condition of the query
     */
    public static void delete(String table, String condition) {
        // string to store the query
        String  query = "DELETE FROM " + table + " WHERE " + condition;
        // execute the query
        execute(query);
    }
}
