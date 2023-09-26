/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Kairav
 */
public class Password {
    public static boolean loggedIn=false;
    public static String code = "4807";

    public static boolean login(String input) {
        return input.equalsIgnoreCase(code);
    }
}
