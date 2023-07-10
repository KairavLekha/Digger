/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import DB.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public class Methods {
    
    public static void deleteMed(String x){
           String sql = "DELETE FROM medication WHERE medicationName ='"+x+"';";
        try {
            DB.DBConnector.update(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }
    
    public static void deletePat(String x ,String y, int z){
           String sql = "DELETE FROM "+x +"WHERE "+y+"='"+z+"';";
        try {
            DB.DBConnector.update(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }
    
    public static String[] searchIll(String x,String y) {
        String sql = "SELECT Illness FROM illnesses WHERE "+y+" LIKE '%" + x+ "%'  ORDER BY idIllnesses";
        String[] illness = new String[10000];

        try {
            ResultSet rs = DBConnector.read(sql);

            int i = 0;
            while (rs.next()) {
                String name = rs.getString("medicationName");
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
        String query2 = "select firstname, surname, PatientNumber FROM Patient WHERE "+y+" LIKE '%"+x+"%'ORDER BY firstname;";
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

    public static String[] refreshIll() {
        String[] illness = new String[10000];
        String sql = "select Illness FROM illnesses ORDER BY idIllnesses;";
        try {
            ResultSet rs = DBConnector.read(sql);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("Illness");
                illness[i] = "Illness:" + name;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return illness;
    }

    public static String[] refreshMed() {
        String sql = "SELECT medicationName FROM medication ORDER BY idmedication;";
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

    public static String[] refreshPat() {
        String sql = "select firstname, surname, PatientNumber FROM Patient ORDER BY firstname;";
        String[] names = new String[10000];
        try {
            ResultSet rs = DBConnector.read(sql);
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("firstname");
                String surname = rs.getString("surname");
                int patientNum = rs.getInt("PatientNumber");
                names[i] = name + " " + surname + " Patient ID:" + patientNum;
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
        return names;
    }

    public static String criteria(String x) {
        if (x == "Firstname") {
            x = "Surname";
        } else if (x == "Surname") {
            x = "Address";
        } else if (x == "Address") {
            x = "PhoneNumber";
        } else if (x == "Phone Number") {
            x = "Date Of Birth";
        } else if (x == "Date Of Birth") {
            x = "Firstname";
        }
        return x;

    }

    public static int getId(String[] x) {
        int i = 0;
        int id = 0;
        for (String a : x) {
            i++;
            if (i == 2) {
                id = Integer.parseInt(a);
            }
        }
        return id;
    }
    
    public static void connect() {
        try {
            DBConnector.init();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Could not find DB driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not connect to db");
        }
    }
}
