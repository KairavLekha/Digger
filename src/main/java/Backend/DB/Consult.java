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

    public static String nextCon(int id, int currentCon, String column) {
        String info = null;

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

        return info;
    }

    public static String lastCon(int id, int currentCon, String column) {
        String info = null;
        if (currentCon >= 1) {
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
        return null;

    }

    public static void addCon(int id, String illness, String med, int currentCon, String date, String symptoms, int newCon) {
        if (currentCon >= newCon) {
            currentCon++;

            String sql = "INSERT INTO consults (idPatient, diagnosis, medication, patientConsult, date, symptom) VALUES ('" + id + "','" + illness + "','" + med + "','" + currentCon + "','" + date + "','" + symptoms + "');";
            try {
                Backend.DB.DBConnector.update(sql);
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
            JOptionPane.showMessageDialog(null, "The consult has been logged");

        } else {
            JOptionPane.showMessageDialog(null, "Go to the newest consult before attempting to log a new one.");
        }
    }

}
