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
public class Illness {

    public static void updateIllness(String x, String y, String z) {
        String sql = "UPDATE illnesses SET Illness='" + x + "',Symptoms='" + y + "' WHERE Illness='" + z + "';";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, "Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }

    public static String loadSingleIllness(String x, String y) {
        String sql = "select Illness,Symptoms FROM illnesses WHERE Illness='" + x + "';";
        String info = null;
        try {
            ResultSet rs = DBConnector.read(sql);
            while (rs.next()) {
                info = rs.getString(y);
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

    public static String[] searchIll(String x, String y) {
        String sql = "SELECT Illness FROM illnesses WHERE " + y + " LIKE '%" + x + "%'  ORDER BY idIllnesses";
        String[] illness = new String[10000];

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
}
