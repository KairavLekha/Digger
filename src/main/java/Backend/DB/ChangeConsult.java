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
public class ChangeConsult {

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
