/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public class Load {
    
   public static String loadSingleIllness(String x,String y){
    String sql = "select Illness,Symptoms FROM illnesses WHERE Illness='"+x+"';";
        String info=null;
        try {
            ResultSet rs = DBConnector.read(sql);
            while (rs.next()) {
               info=rs.getString(y);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
       return info;
   }
    
    public static String loadSingleMedication(String x, String y ){
        String info=null;
        String sql = "SELECT medicationName, stockRemaining, sideEffects, allergens, illnessTreated  FROM medication WHERE medicationName='" + y + "';";
        try {
            ResultSet rs = DBConnector.read(sql);
            while (rs.next()) {
                info=rs.getString(x);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        
        return info;
        
    }
    
    public static String loadSinglePatient(String x, int y ){
        String sql = "SELECT "+ x +" FROM patient WHERE PatientNumber='" + y + "';";
        String info = null;
        try {
            ResultSet rs = DBConnector.read(sql);
            while (rs.next()) {
                 info=rs.getString(x);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return info;
    }
    
    public static String[] loadIllnessList() {
        String[] illness = new String[10000];
        String sql = "select Illness FROM illnesses ORDER BY idIllnesses;";
        try {
            ResultSet rs = DBConnector.read(sql);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("Illness");
                illness[i] = name;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return illness;
    }

    public static String[] loadMedicationList() {
        String sql = "SELECT medicationName FROM medication ORDER BY idmedication;";
        String[] medication = new String[10000];
        try {
            ResultSet rs = DBConnector.read(sql);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("medicationName");
                medication[i] = name;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return medication;
    }

    public static String[] loadPatientList() {
        String sql = "select firstname, surname, PatientNumber FROM Patient ORDER BY firstname;";
        String[] names = new String[10000];
        try {
            ResultSet rs = DBConnector.read(sql);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("firstname");
                String surname = rs.getString("surname");
                int patientNum = rs.getInt("PatientNumber");
                names[i] = name + " " + surname + " Patient ID:" + patientNum;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return names;
    }
    
}
