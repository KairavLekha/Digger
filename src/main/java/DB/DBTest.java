/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public class DBTest {
    public static void main(String[] args) {
        try {
            DBConnector.init();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Could not find DB driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Could not connect to db");
        }
        
        //update, delete, insert
        //String query = "UPDATE tblpatients SET medical_condition='cancer' WHERE id=1;";
        //String query = "INSERT INTO tblpatients(name, surname, medical_condition, weight, height) VALUES('James', 'Paulers', 'idiot', 88,191);";
//        String query = "DELETE FROM tblpatients WHERE id=3;";
//        try {
//            DBConnector.update(query);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null,"Error in SQL query");
//        }
        
        //select
        String query2 = "SELECT firstname, surname,PatientNumber FROM Patient;";
        try {
            ResultSet rs = DBConnector.read(query2);
            
            String[] names = new String[2];
            int i = 0;
            while(rs.next()){
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int idnum = rs.getInt("PatientNumber");
                names[i] = name + " " + surname;
                i++;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error in SQL query");
        }
    }
}
