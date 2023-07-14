/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
//ColumnNames
//PatientNumber
//Firstname
//Surname
//DateOfBirth
//Medical_Conditions
//PhoneNumber
//Address
//Visits
public class DBConnector {

    private static Connection conn;
    private static PreparedStatement ps;

    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/patientsdb";
        conn = DriverManager.getConnection(connectionUrl, "root", "KAIRAVcr7");
    }

    //delete, update, insert
    public static void update(String query) throws SQLException {
        ps = conn.prepareStatement(query);
        ps.executeUpdate();
    }

    //select
    public static ResultSet read(String query) throws SQLException {
        ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    //connect
    public static void connect() {
        try {
            DBConnector.init();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Could not find DB driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not connect to db");
        }
    }

}
