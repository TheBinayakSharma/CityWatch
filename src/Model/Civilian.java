/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binay
 */
public class Civilian {
    private String civId;
    private String name;
    private String address;
    private String email;
    private String phone;
    
    public Civilian(String civId, String name, String address, String email, String phone) {
        this.civId = civId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        
    }
    
    public String getCivId(){
        return this.civId;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
        
    
    
}
