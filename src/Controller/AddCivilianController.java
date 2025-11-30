/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Civilian;
import Model.StructuralStorage;
import Model.LoginCredentials;

/**
 *
 * @author binay
 */
public class AddCivilianController {
    
    public void registerCivilian(String civId, String name, String phone, String email, String address, String password) throws Exception{
        for(Civilian c: StructuralStorage.civilianArrayList){
            if (c.getPhone().equals(phone) ){
                throw new Exception("A user under the given phone number already exists");
            }
            Civilian civ = new Civilian(civId, name, address, email, phone);
            StructuralStorage.civilianArrayList.add(civ);
            LoginCredentials.addCivLoginCred(civId, password);
        }
        
        
        
    }
    
    public String setCivId(String name, String phone){
        return "CIV-"+name.substring(0,3)+phone;
    }
}
