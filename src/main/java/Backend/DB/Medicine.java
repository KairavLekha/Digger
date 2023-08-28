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
public class Medicine {

    public static String loadSingleMedication(String x, String y) {
        String sql = "SELECT medicationName, stockRemaining, sideEffects, allergens, illnessTreated  FROM medication WHERE medicationName='" + y + "';";
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

    public static String[] searchMed(String x, String y) {
        String sql = "SELECT medicationName FROM medication WHERE " + y + " LIKE '%" + x + "%'  ORDER BY idmedication";
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

    public static String[] loadMedicationList() {
        String sql = "SELECT medicationName FROM medication ORDER BY stockRemaining;";
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

    public static void updateMedication(String v, int w, String x, String y, String u, String z) {
        String sql = "UPDATE medication SET medicationName='" + v + "', stockRemaining='" + w + "', sideEffects='" + x + "', allergens='" + y + "', illnessTreated='" + u + "' WHERE medicationName='" + z + "';";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, "Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

    }

    public static void deleteMed(String x) {
        String sql = "DELETE FROM medication WHERE medicationName ='" + x + "';";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, x + " has been deleted");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }

}
