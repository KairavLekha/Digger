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
        switch (x) {
            case "Firstname":
                x = "Surname";
                break;
            case "Surname":
                x = "Address";
                break;
            case "Address":
                x = "Phone_Number";
                break;
            case "Phone_Number":
                x = "Date_Of_Birth";
                break;
            case "Date_Of_Birth":
                x = "Firstname";
                break;
            default:
                break;
        }
        return x;

    }

    public static String criteriaOut(String x) {
        String y="";
        switch (x) {
            case "Firstname":
                y = "Surname";
                break;
            case "Surname":
                y = "Address";
                break;
            case "Address":
                y = "Phone Number";
                break;
            case "Phone_Number":
                y = "Date Of Birth";
                break;
            case "Date_Of_Birth":
                y = "Firstname";
                break;
            default:
                break;
        }
    return y ;

}

public static int getId(String x) {
        String[] patientinfo = x.split(":", 0);
        int id = Integer.parseInt(patientinfo[1]);
        return id;
    }

    public static boolean login(String x) {
        return x.equalsIgnoreCase("4807");
    }
}
