/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.HashMap;

/**
 *
 * @author binay
 */
public class LoginCredentials {
    protected static HashMap<String,String> civLoginCred = new HashMap<>();
    protected static HashMap<String,String> orgLoginCred = new HashMap<>();
    
    public static void addCivLoginCred(String username, String password){
        civLoginCred.put(username, password);
    }
    
    public static void addOrgLoginCred(String username, String password){
        orgLoginCred.put(username, password);
    }   
    
    public static String getOrgLoginCred(String username){
        return orgLoginCred.get(username);
    }
    
    public static String getCivLoginCred(String username){
        return civLoginCred.get(username);
    }
    
}
