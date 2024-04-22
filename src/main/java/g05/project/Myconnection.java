/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g05.project;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author CHAMMA
 */
public class Myconnection {

    public static Connection connection;
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String DATABASE = "emp_db";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE, USERNAME, PASSWORD);
        }
        return connection;
    }

    public static ResultSet search(String query, ArrayList list) throws ClassNotFoundException, SQLException {
        PreparedStatement prepareStatement = createConnection().prepareStatement(query);
        for (int i = 0; i < list.size(); i++) {
            prepareStatement.setObject(i + 1, list.get(i));
        }
        return prepareStatement.executeQuery();
    }
    
    public static ResultSet search(String query) throws ClassNotFoundException, SQLException {
        Statement createStatement = createConnection().createStatement();
        return createStatement.executeQuery(query);
    }

    public static void iud(String query) {
        try {
            Statement createStatement = createConnection().createStatement();
            createStatement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void iudSafe(String query, ArrayList list) {
        try {
            PreparedStatement prepareStatement = createConnection().prepareStatement(query);
            for (int i = 0; i < list.size(); i++) {
                prepareStatement.setObject(i + 1, list.get(i));
            }
            prepareStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
