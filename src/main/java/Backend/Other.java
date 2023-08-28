/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Kairav
 */
public class Other {
    
    
    public static String criteria(String x) {
        if ("Firstname".equals(x)) {
            x = "Surname";
        } else if ("Surname".equals(x)) {
            x = "Address";
        } else if ("Address".equals(x)) {
            x = "Phone_Number";
        } else if ("Phone_Number".equals(x)) {
            x = "Date_Of_Birth";
        } else if ("Date_Of_Birth".equals(x)) {
            x = "Firstname";
        }
        return x;

    }

    public static int getId(String x) {
        int id = 0;
        int i=0;
        String[] arrOfStr = x.split(":", 0);
        for (String a : arrOfStr) {
            i++;
            if (i == 2) {
                id = Integer.parseInt(a);
            }
        }
        return id;
    }
    
    public static boolean login(String x){
        return x.equalsIgnoreCase("4807");  
    }
}
