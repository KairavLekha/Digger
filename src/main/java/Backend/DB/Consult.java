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
public class Consult {

    public static String nextCon(int id, int currentCon, int newCon, String column) {
        String info = null;
        if (currentCon <= newCon) {
            String sql = "SELECT diagnosis, medication, date, symptom FROM consults WHERE patientConsult='" + currentCon + "' AND idPatient='" + id + " ';";
            try {
                ResultSet rs = DBConnector.read(sql);
                while (rs.next()) {
                    info = rs.getString(column);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in SQL query");
            }
        } else {

            info = "";

        }
        return info;
    }

    public static String lastCon(int id, int currentCon, String column) {
        String info = null;

        String sql = "SELECT diagnosis, medication, date, symptom FROM consults WHERE patientConsult='" + currentCon + "'AND idPatient='" + id + " ';";
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

    public static void addCon(int id, String illness, String med, int currentCon, String date, String symptoms) {
        String sql = "INSERT INTO consults (idPatient, diagnosis, medication, patientConsult, date, symptom) VALUES ('" + id + "','" + illness + "','" + med + "','" + currentCon + "','" + date + "','" + symptoms + "');";
        try {
            Backend.DB.DBConnector.update(sql);
            currentCon++;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

        String qry = "UPDATE patient SET numConsult='" + currentCon + "'WHERE PatientNumber=" + id + ";";
        try {
            Backend.DB.DBConnector.update(qry);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        
        int stock = (Integer.parseInt(Medicine.loadSingleMedication("stockRemaining", med)) - 1);
        
        String qry2 = "UPDATE medication SET stockRemaining='" + stock + "'WHERE medicationName LIKE '%" + med + "%'";
        try {
            DBConnector.update(qry2);
            JOptionPane.showMessageDialog(null, "This consult has been Logged");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

    }

}
