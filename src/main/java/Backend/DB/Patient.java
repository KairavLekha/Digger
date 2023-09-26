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

    public static int getId(String listItem) {
        String[] patientinfo = listItem.split(":", 0);
        int id = Integer.parseInt(patientinfo[1]);
        return id;
    }

    public static String criteria(String crit) {
        switch (crit) {
            case "Firstname":
                crit = "Surname";
                break;
            case "Surname":
                crit = "Address";
                break;
            case "Address":
                crit = "Phone_Number";
                break;
            case "Phone_Number":
                crit = "Date_Of_Birth";
                break;
            case "Date_Of_Birth":
                crit = "Firstname";
                break;
            default:
                break;
        }
        return crit;

    }

    public static String criteriaOut(String crit) {
        String critOut = "";
        switch (crit) {
            case "Firstname":
                critOut = "Firstname";
                break;
            case "Surname":
                critOut = "Surname";
                break;
            case "Address":
                critOut = "Address";
                break;
            case "Phone_Number":
                critOut = "Phone Number";
                break;
            case "Date_Of_Birth":
                critOut = "Date Of Birth";
                break;
            default:
                break;
        }
        return critOut;

    }

    public static void updatePatient(String name, String surname, String DOB, String medCon, String phoneNum, String address, String allergy, int id) {
        String sql = "UPDATE patient SET Firstname='" + name + "', Surname='" + surname + "', Date_Of_Birth='" + DOB + "', Medical_Conditions='" + medCon + "', Phone_Number='" + phoneNum + "', Address= '" + address + "', Allergy='" + allergy + "' WHERE PatientNumber=" + id + ";";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, "Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }

    public static void addPat(String name, String surname, String DOB, String medCon, String phoneNum, String address, String allergy) {
        String sql = "INSERT INTO patient (Firstname, Surname, Date_Of_Birth, Medical_Conditions, Phone_Number, Address, Allergy, numConsult ) VALUES ('" + name + "','" + surname + "','" + DOB + "','" + medCon+ "','" + phoneNum + "','" + address + "','" + allergy + "', 0);";
        try {
            Backend.DB.DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, name + " has been added");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

    }

    public static String[] searchPat(String input, String crit) {
        String sql = "select firstname, surname, PatientNumber FROM Patient WHERE " + crit + " LIKE '" + input + "%'ORDER BY firstname;";
        String[] list = new String[10000];
        try {
            ResultSet rs = DBConnector.read(sql);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("firstname");
                String surname = rs.getString("surname");
                int patientNum = rs.getInt("PatientNumber");
                list[i] = name + " " + surname + " Patient ID:" + patientNum;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return list;

    }

    public static void deletePat(String name, int id) {
        String sql = "DELETE FROM patient WHERE PatientNumber='" + id + "';";
        try {
            DBConnector.update(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        String qry = "DELETE FROM consults WHERE idPatient='" + id + "';";
        try {
            DBConnector.update(qry);
            JOptionPane.showMessageDialog(null, name + " has been deleted");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }

    public static String loadSinglePatient(String column, int id) {
        String sql = "SELECT " + column + " FROM patient WHERE PatientNumber='" + id + "';";
        String info = null;
        try {
            ResultSet rs = DBConnector.read(sql);
            while (rs.next()) {
                info = rs.getString(column);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return info;
    }

    public static String[] loadPatientList() {
        String sql = "select firstname, surname, PatientNumber FROM Patient ORDER BY firstname;";
        String[] list = new String[10000];
        try {
            ResultSet rs = DBConnector.read(sql);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("firstname");
                String surname = rs.getString("surname");
                int patientNum = rs.getInt("PatientNumber");
                list[i] = name + " " + surname + " Patient ID:" + patientNum;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return list;
    }
}
