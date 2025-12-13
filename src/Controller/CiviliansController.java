/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Civilian;
import Model.StructuralStorage;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author binay
 */
public class CiviliansController {
    
    public void registerCivilian(String civId, String name, String phone, String email, String address, String password) throws Exception{
        for(Civilian c: StructuralStorage.civilianArrayList){
            if (c.getPhone().equals(phone) ){
                throw new Exception("A User under the given phone number already exists");
            }
        }
            Civilian civ = new Civilian(civId, name, address, email, phone);
            StructuralStorage.civilianStack.push(civ);
            StructuralStorage.updateCivilianArrayList();
            LoginAndRegistrationController.addCivLoginCred(civId, password);   
    }
    
    public String setCivId(String name, String phone){
        return "CIV-"+name.substring(0,3)+phone;
    }
    
    public static ArrayList<Civilian> getCivilianAL(){
        return Model.StructuralStorage.civilianArrayList;
    } 
    
    public static void updateCivs(String id, String name, String email, String phone, String address){
        for(Civilian c: StructuralStorage.civilianStack){
            if(c.getCivId().equals(id)){
                c.setAddress(address);
                c.setEmail(email);
                c.setName(name);
                c.setPhone(phone);
            }
        }
        StructuralStorage.updateCivilianArrayList();  
    }
    
    public static void removeCiv (String id) throws Exception{
        Iterator<Civilian> iter = StructuralStorage.civilianStack.iterator();
        while(iter.hasNext()) {
            Civilian c = iter.next();
            if(c.getCivId().equals(id)) {
                iter.remove(); // safe removal
                StructuralStorage.updateCivilianArrayList();
                return;
            }
        }
        throw new Exception("Invalid User Id");
    }
}
