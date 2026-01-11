/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binay
 */

/**
 * Represents a civilian user in the system.
 */

public class Civilian {
    private final String civId;
    private String name;
    private String address;
    private String email;
    private String phone;
    
    /**
    * Constructs a Civilian object with the given details.
    *
    * @param civId the unique identifier of the civilian
    * @param name the name of the civilian
    * @param address the residential address of the civilian
    * @param email the email address of the civilian
    * @param phone the phone number of the civilian
    */
    public Civilian(String civId, String name, String address, String email, String phone) {
        this.civId = civId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        
    }
    
    /**
    * Returns the civilian ID
    *
    * @return the unique civilian ID
    */

    public String getCivId(){
        return this.civId;
    }
    
    /**
    * Returns the civilian name
    *
    * @return the name of the civilian
    */

    public String getName(){
        return this.name;
    }
    
    /**
    * Returns the civilian address
    *
    * @return the address of the civilian
    */
    public String getAddress(){
        return this.address;
    }
    
    /**
    * Returns the civilian email address
    *
    * @return the email of the civilian
    */
    public String getEmail(){
        return this.email;
    }
    
    /**
    * Returns the civilian phone number
    *
    * @return the phone number of the civilian
    */
    public String getPhone(){
        return this.phone;
    }
    
    /**
    * Updates the civilian name
    *
    * @param name the new name to set
    */

    public void setName(String name){
        this.name = name;
    }
    
    /**
    * Updates the civilian address
    *
    * @param address the new address to set
    */

    public void setAddress(String address){
        this.address = address;
    }
    
    /**
    * Updates the civilian email address
    *
    * @param email the new email to set
    */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
    * Updates the civilian phone number
    *
    * @param phone the new phone number to set
    */

    public void setPhone(String phone){
        this.phone = phone;
    }
        
    
    
}
