/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
/**
 *
 * @author binay
 */

import Model.Admin;
import Model.Civilian;
import Model.Notice;
import Model.Organization;
import Model.Task;
import Model.LoginCredentials;

public class LoginAndRegistrationController {
    
    public static boolean adminAuthenticate(String username, String password){
        Admin a = new Admin();
        if(username.equals(a.getUsername()) && password.equals(a.getPassword())){
            return true;
        }
        return false;
    }
    
    
    public static boolean orgAuthenticate(String username, String password){
        if((getOrgLoginCred(username)).equals(password)){
          return true;  
        }
        return false;  
    }
    
    public static boolean civAuthenticate(String username, String password){
        if((getCivLoginCred(username)).equals(password)){
          return true;  
        }
        return false;
    }
    
    public static void addCivLoginCred(String username, String password){
        LoginCredentials.civLoginCred.put(username, password);
    }
    
    public static void addOrgLoginCred(String username, String password){
        LoginCredentials.orgLoginCred.put(username, password);
    }   
    
    public static String getOrgLoginCred(String username){
        return LoginCredentials.orgLoginCred.get(username);
    }
    
    public static String getCivLoginCred(String username){
        return LoginCredentials.civLoginCred.get(username);
    }
    
}
