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

    public static String loadSingleMedication(String column, String input) {
        String sql = "SELECT medicationName, stockRemaining, sideEffects, allergens, illnessTreated  FROM medication WHERE medicationName='" + input + "';";
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

    public static String[] searchMed(String input, String crit) {
        String sql = "SELECT medicationName FROM medication WHERE " + crit + " LIKE '%" + input + "%'  ORDER BY idmedication";
        String[] medlist = new String[10000];

        try {
            ResultSet rs = DBConnector.read(sql);

            int i = 0;
            while (rs.next()) {
                String medName = rs.getString("medicationName");
                medlist[i] = medName;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return medlist;

    }

    public static void addMed(String medName, String allergen, String effects, String treats, int stock) {
        if (medName.isBlank() || allergen.isBlank() || effects.isBlank() || treats.isBlank() || ("" + stock).isBlank()) {

            JOptionPane.showMessageDialog(null, "A field cannot be left blank");
        } else {

            String sql = "INSERT INTO medication (medicationName, allergens , sideEffects,illnessTreated, stockRemaining ) VALUES ('" + medName + "','" + allergen + "','" + effects + "','" + treats + "','" + stock + "');";
            try {
                Backend.DB.DBConnector.update(sql);
                JOptionPane.showMessageDialog(null, medName + " has been added");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in SQL query");
            }
        }

    }

    public static String[] loadMedicationList() {
        String sql = "SELECT medicationName FROM medication ORDER BY stockRemaining;";
        String[] medlist = new String[10000];
        try {
            ResultSet rs = DBConnector.read(sql);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("medicationName");
                medlist[i] = name;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return medlist;
    }

    public static void updateMedication(String medName, int stock, String effects, String allergen, String treats, String input) {
        String sql = "UPDATE medication SET medicationName='" + medName + "', stockRemaining='" + stock + "', sideEffects='" + effects + "', allergens='" + allergen + "', illnessTreated='" + treats + "' WHERE medicationName='" + input + "';";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, "Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }

    }

    public static void deleteMed(String medName) {
        String sql = "DELETE FROM medication WHERE medicationName ='" + medName + "';";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, medName + " has been deleted");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }

}
