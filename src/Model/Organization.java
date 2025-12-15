/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author binay
 */
public class Organization {
    private String orgId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private ArrayList<Task> taskAssigned;
    private ArrayList<Task> taskCompleted;
    
    public Organization(String orgId, String name, String phone, String email,
            String address){
        this.orgId = orgId;
        this.name = name;
        this.email = email; 
        this.phone = phone;
        this.address = address;
        taskAssigned = new ArrayList<>();
        taskCompleted = new ArrayList<>();
        
    }
    
    public String getOrgId(){
        return this.orgId;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public ArrayList<Task> getTaskAssigned() {
        return taskAssigned;
    }

    public ArrayList<Task> getTaskCompleted() {
        return taskCompleted;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    
    
    
    public String createOrgId(String name, String phone){
        return "ORG-"+name.substring(0,3)+ phone;
    }
}
