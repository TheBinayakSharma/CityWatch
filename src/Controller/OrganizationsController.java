/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.ArrayList;

import Model.Organization;
import Model.StructuralStorage;
import Model.Task;
import java.util.Iterator;
import java.util.UUID;

/**
 *
 * @author binay
 */
public class OrganizationsController {
    public void registerOrganization(String orgId, String name, String phone, String email, String address, String password) throws Exception{
        for(Organization o: StructuralStorage.organizationArrayList){
            if (o.getPhone().equals(phone) ){
                throw new Exception("A User under the given phone number already exists");
            }
        }
        Organization org = new Organization(orgId,name,phone,email,address);
        StructuralStorage.organizationStack.push(org);
        StructuralStorage.updateOrganizationArrayList();
        LoginAndRegistrationController.addOrgLoginCred(orgId, password);
    }
    
    public String setOrgId(String name){
        return "ORG-"+name.substring(0,3)+UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }
    
    public static ArrayList<Organization> getOrganizationAL(){
        return Model.StructuralStorage.organizationArrayList;
    } 
    
    public static void updateOrgs(String id, String name, String email, String phone, String address){
        for(Organization o: StructuralStorage.organizationStack){
            if(o.getOrgId().equals(id)){
                o.setAddress(address);
                o.setEmail(email);
                o.setName(name);
                o.setPhone(phone);
            }
        }
        StructuralStorage.updateOrganizationArrayList();
    }
    
    public static void removeOrg(String id) throws Exception{
        Iterator<Organization> iter = StructuralStorage.organizationStack.iterator();
        while(iter.hasNext()) {
            Organization o = iter.next();
            if(o.getOrgId().equals(id)) {
                iter.remove(); // safe removal
                StructuralStorage.updateOrganizationArrayList();
                return;
            }
        }
       
       throw new Exception("Invalid User ID");
    }
    
    public static void removeRecentlyAdded(){
        StructuralStorage.organizationStack.pop();
        StructuralStorage.updateOrganizationArrayList();
    }
    
    public static ArrayList<Task> getOrgTIPList(String sessionUser){
        for(Organization o: StructuralStorage.organizationStack){
            if(o.getOrgId().equalsIgnoreCase(sessionUser)){
                return o.getTaskAssigned();
            }
        }
        return new ArrayList();
    }
    
    public static ArrayList<Task> getOrgComTaskList(String sessionUser){
        for(Organization o: StructuralStorage.organizationStack){
            if(o.getOrgId().equalsIgnoreCase(sessionUser)){
                return o.getTaskCompleted();
            }
        }
        return new ArrayList();
    }
    
    public static void markTaskComplete(Organization o, Task t){
        t.setCompletedBy(LoginAndRegistrationController.sessionUser);
        o.getTaskAssigned().remove(t);
        o.getTaskCompleted().add(t);
        TaskController.getTaskIPAL().remove(t);
        TaskController.getComTaskAL().add(t);
    }
}
