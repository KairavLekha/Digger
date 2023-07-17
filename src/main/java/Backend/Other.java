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

    public static int getId(String x) {
        int i = 0;
        int id = 0;
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
        int code = Integer.parseInt(x);
        if (code==4807){
            return true;
        }
        return false;  
    }
}
