/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import DB.DBConnector;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public class Methods {

    public static void connect() {
        try {
            DBConnector.init();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Could not find DB driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not connect to db");
        }
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
}
