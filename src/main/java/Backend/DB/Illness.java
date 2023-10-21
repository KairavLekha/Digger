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

    public static void updateIllness(String illName, String symp, String input) {
        String sql = "UPDATE illnesses SET Illness='" + illName + "',Symptoms='" + symp + "' WHERE Illness='" + input + "';";
        try {
            DBConnector.update(sql);
            JOptionPane.showMessageDialog(null, "Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }

    public static String loadSingleIllness(String illName, String column) {
        String sql = "select Illness,Symptoms FROM illnesses WHERE Illness='" + illName + "';";
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

    public static void addIll(String illName, String symp) {
        if (illName.isBlank()||symp.isBlank()) {
            JOptionPane.showMessageDialog(null, "A field cannot be left blank");
        }else{
            String sql = "INSERT INTO illnesses (Illness, Symptoms) VALUES ('" + illName + "','" + symp + "');";
            try {
                Backend.DB.DBConnector.update(sql);
                JOptionPane.showMessageDialog(null, illName + " has been added");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in SQL query");
            }
            
        }

    }

    public static String[] searchIll(String input, String crit) {
        String sql = "SELECT Illness FROM illnesses WHERE " + crit + " LIKE '%" + input + "%'  ORDER BY idIllnesses";
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
