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
public class Update {
    
    public static void updateIllness(String x,String y,String z) {
     String sql = "UPDATE illnesses SET Illness='"+x+"',Symptoms='"+y+"' WHERE medicationName='"+z+"';";
        try {
            Backend.DB.DBConnector.update(sql);
            JOptionPane.showMessageDialog(null,"Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }
        
    public static void updateMedication(String v,int w,String x,String y,String z,String u) {
         String sql = "UPDATE medication SET medicationName='"+v+"', stockRemaining='"+w+"', sideEffects='"+x+"', allergens='"+y+"', illnessTreated='"+z+"' WHERE medicationName='"+u+"';";
        try {
            Backend.DB.DBConnector.update(sql);
            JOptionPane.showMessageDialog(null,"Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        
    }
    
    public static void updatePatient(String s,String t,String u,String v,String w,String x,String y,int z){
          String sql = "UPDATE patient SET Firstname='"+s+"', Surname='"+t+"', DateOfBirth='"+u+"', Medical_Conditions='"+v+"', PhoneNumber='"+w+"', Address= '"+x+"', Allergy='"+y+"' WHERE PatientNumber="+z+";";
        try {
            Backend.DB.DBConnector.update(sql);
            JOptionPane.showMessageDialog(null,"Information Has Been Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }   
    
    public static String downloadSelected(){
      String sql = "select identifier FROM selected;";
      String id = null;
      //download
      try {
          ResultSet rs = DBConnector.read(sql);
            while (rs.next()) {
                id = rs.getString("identifier");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }   
        return id;
    }
    
    public static void uploadSelected(String x){
      String sql = "UPDATE selected SET identifier='"+x+"'WHERE selectedID=1;";
        try {
            DBConnector.update(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }   
    }
    
    public static void clearSelected(){
      String sql = "UPDATE selected SET identifier=''WHERE selectedID=1;";
        try {
            DBConnector.update(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }   
    }
    
}
