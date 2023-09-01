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

    public static String nextCon(int u, int x, int y, String z) {
        String info = null;
        if (x <= y) {
            String sql = "SELECT diagnosis, medication, date, symptom FROM consults WHERE patientConsult='" + x + "' AND idPatient='" + u + " ';";
            try {
                ResultSet rs = DBConnector.read(sql);
                while (rs.next()) {
                    info = rs.getString(z);
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
    public static void addCon(int u,String v, String w, int x, String y, String z) {
       String sql = "INSERT INTO consults (idPatient, diagnosis, medication, patientConsult, date, symptom) VALUES ('" + u + "','" + v + "','" + w + "','" + x + "','" + y + "','" + z + "');";
        try {
            Backend.DB.DBConnector.update(sql);
            x++;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

        String qry = "UPDATE patient SET numConsult='" + x + "'WHERE PatientNumber="+u+";";
        try {
            Backend.DB.DBConnector.update(qry);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        int a =(Integer.parseInt(Medicine.loadSingleMedication("stockRemaining", w))-1);
        String qry1 = "UPDATE medication SET stockRemaining='" +a + "'WHERE medicationName LIKE '%" + w + "%'";
        try {
            Backend.DB.DBConnector.update(qry1);
            JOptionPane.showMessageDialog(null, "This consult has been Logged");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        
}
    public static String lastCon(int x, int y, String z) {
        String info = null;

        String sql = "SELECT diagnosis, medication, date, symptom FROM consults WHERE patientConsult='" + y + "'AND idPatient='" + x + " ';";
        try {
            ResultSet rs = DBConnector.read(sql);
            while (rs.next()) {
                info = rs.getString(z);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

        return info;
    }
}
