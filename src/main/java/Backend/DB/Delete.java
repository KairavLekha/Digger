/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public class Delete {
        
    public static void deleteMed(String x){
           String sql = "DELETE FROM medication WHERE medicationName ='"+x+"';";
        try {
            DBConnector.update(sql);
             JOptionPane.showMessageDialog(null, x + " has been deleted");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }
    
    public static void deletePat( String w, int x){
           String sql = "DELETE FROM patient WHERE PatientNumber='"+x+"';";
        try {
            DBConnector.update(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
           String qry = "DELETE FROM consults WHERE idPatient='"+x+"';";
        try {
            DBConnector.update(sql);
             JOptionPane.showMessageDialog(null, w + " has been deleted");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }
}
