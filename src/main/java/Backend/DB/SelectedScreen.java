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
public class SelectedScreen {
    public static String downloadSelected(){
      String sql = "select identifier FROM selectedscreen;";
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
    
    public static void uploadSelected(String screen){
      String sql = "UPDATE selectedscreen SET identifier='"+screen+"'WHERE selectedID=1;";
        try {
            DBConnector.update(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }   
    }
    
    
    
}
