/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * @author binay
 */

/**
 * Represents the system administrator with fixed login credentials.
 */
public class Admin {
    
    private final String username;
    private final String password;
    
    /**
    * Constructs an Admin object with predefined username and password
    */
    public Admin(){
        this.username = "ADM-binsha";
        this.password = "binsha";
    }
    
    /**
    * Returns the admin's username
    * @return the username of admin
    */
    public String getUsername(){
        return this.username;
    }
    
    /**
    * Returns the admin's password.
    * @return the password of admin
    */
    public String getPassword(){
        return this.password;
    }
    
}
