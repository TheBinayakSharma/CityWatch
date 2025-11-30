/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binay
 */
public class Organization {
    private String orgId;
    private String name;
    private String phone;
    private String email;
    private int tasksCompleted;
    private String currentTaskId;
    
    public Organization(String orgId, String name, String phone, String email,
            String address){
        this.orgId = orgId;
        this.name = name;
        this.email = email; 
        this.tasksCompleted = 0;
        this.currentTaskId= null;        
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
    
    
    public int getTasksCompleted(){
        return this.tasksCompleted;
    }
    
    public String getCurrenttaskId(){
        return this.currentTaskId;
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
    
    public void setTasksCompleted(int tasksCompleted){
        this.tasksCompleted = tasksCompleted;
    }
    
    public void setCurrentTaskId(String currentTaskId){
        this.currentTaskId = currentTaskId;
    }
    
    public String createOrgId(String name, String phone){
        return "ORG-"+name.substring(0,3)+ phone;
    }
}
