/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB;

import Backend.DB.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public class Search {
    
     public static String[] searchIll(String x,String y) {
        String sql = "SELECT Illness FROM illnesses WHERE "+y+" LIKE '%" + x+ "%'  ORDER BY idIllnesses";
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
    
    public static String[] searchMed(String x,String y) {
        String sql = "SELECT medicationName FROM medication WHERE "+y+" LIKE '%" + x+ "%'  ORDER BY idmedication";
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
    
    public static String[] searchPat(String x,String y) {
        String query2 = "select firstname, surname, PatientNumber FROM Patient WHERE "+y+" LIKE '"+x+"%'ORDER BY firstname;";
        String[] names = new String[10000];
        try {
            ResultSet rs = DBConnector.read(query2);  
            int i = 0;
            while(rs.next()){
                String name = rs.getString("firstname");
                String surname = rs.getString("surname");
                int patientNum = rs.getInt("PatientNumber");
                names[i] =name+ " "+surname+" Patient ID:"+patientNum;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error in SQL query");
        }
        return names;

    }
}
