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
public class Patient {

    public static int getId(String x) {
        String[] patientinfo = x.split(":", 0);
        int id = Integer.parseInt(patientinfo[1]);
        return id;
    }

    public static String criteria(String x) {
        switch (x) {
            case "Firstname":
                x = "Surname";
                break;
            case "Surname":
                x = "Address";
                break;
            case "Address":
                x = "Phone_Number";
                break;
            case "Phone_Number":
                x = "Date_Of_Birth";
                break;
            case "Date_Of_Birth":
                x = "Firstname";
                break;
            default:
                break;
        }
        return x;

    }

    public static String criteriaOut(String x) {
        String y = "";
        switch (x) {
            case "Firstname":
                y = "Surname";
                break;
            case "Surname":
                y = "Address";
                break;
            case "Address":
                y = "Phone Number";
                break;
            case "Phone_Number":
                y = "Date Of Birth";
                break;
            case "Date_Of_Birth":
                y = "Firstname";
                break;
            default:
                break;
        }
        return y;

    }

    public static void updatePatient(String s, String t, String u, String v, String w, String x, String y, int z) {
        String sql = "UPDATE patient SET Firstname='" + s + "', Surname='" + t + "', Date_Of_Birth='" + u + "', Medical_Conditions='" + v + "', Phone_Number='" + w + "', Address= '" + x + "', Allergy='" + y + "' WHERE PatientNumber=" + z + ";";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, "Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }

    public static void addPat(String t, String u, String v, String w, String x, String y, String z) {
        String sql = "INSERT INTO patient (Firstname, Surname, Date_Of_Birth, Medical_Conditions, Phone_Number, Address, Allergy, numConsult ) VALUES ('" + t + "','" + u + "','" + v + "','" + w + "','" + x + "','" + y + "','" + z + "', 0);";
        try {
            Backend.DB.DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, t + " has been added");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

    }

    public static String[] searchPat(String x, String y) {
        String query2 = "select firstname, surname, PatientNumber FROM Patient WHERE " + y + " LIKE '" + x + "%'ORDER BY firstname;";
        String[] names = new String[10000];
        try {
            ResultSet rs = DBConnector.read(query2);
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

    public static void deletePat(String w, int x) {
        String sql = "DELETE FROM patient WHERE PatientNumber='" + x + "';";
        try {
            DBConnector.update(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        String qry = "DELETE FROM consults WHERE idPatient='" + x + "';";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, w + " has been deleted");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }

    public static String loadSinglePatient(String x, int y) {
        String sql = "SELECT " + x + " FROM patient WHERE PatientNumber='" + y + "';";
        String info = null;
        try {
            ResultSet rs = DBConnector.read(sql);
            while (rs.next()) {
                info = rs.getString(x);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return info;
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
