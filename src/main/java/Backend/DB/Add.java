/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public class Add {

    public static void addIll(String x, String y) {

        String sql = "INSERT INTO illnesses (Illness, Symptoms) VALUES ('" + x + "','" + y + "');";
        try {
            Backend.DB.DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, x + " has been added");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

    }

    public static void addMed(String v, String w, String x, String y, int z) {
        String sql = "INSERT INTO medication (medicationName, allergens , sideEffects,illnessTreated, stockRemaining ) VALUES ('" + v + "','" + w + "','" + x + "','" + y + "','" + z + "');";
        try {
            Backend.DB.DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, v + " has been added");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }
    
    public static void addPat(String t,String u,String v, String w, String x, String y, String z) {
         String sql = "INSERT INTO patient (Firstname, Surname, Date Of Birth, Medical_Conditions, Phone Number, Address, Allergy, numConsult ) VALUES ('" + t + "','" + u + "','" + v + "','" + w + "','" + x + "','" + y + "','" + z + "', 0);";
        try {
            Backend.DB.DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, t+" has been added");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

    }
    
    public static void addCon(int u,String v, String w, int x, String y, String z) {
       String sql = "INSERT INTO consults (idPatient, diagnosis, medication, patientConsult, date, symptom) VALUES ('" + u + "','" + v + "','" + w + "','" + x + "','" + y + "','" + z + "');";
        try {
            Backend.DB.DBConnector.update(sql);
            x++;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

        String qry = "INSERT INTO patient (numConsults) VALUES ('" + x + "');";
        try {
            Backend.DB.DBConnector.update(qry);
            JOptionPane.showMessageDialog(null, "This consult has been Logged");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
}
}
