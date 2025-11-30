/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Organization;
import Model.LoginCredentials;
import Model.StructuralStorage;

/**
 *
 * @author binay
 */
public class AddOrganizationController {
    public void registerOrganization(String orgId, String name, String phone, String email, String address, String password) throws Exception{
        for(Organization o: StructuralStorage.organizationArrayList){
            if (o.getPhone().equals(phone) ){
                throw new Exception("An organization under the given phone number already exists");
            }
            Organization org = new Organization(orgId,name,phone,email,address);
            StructuralStorage.organizationArrayList.add(org);
            LoginCredentials.addCivLoginCred(orgId, password);
        }
    }
    
    public String setOrgId(String name, String phone){
        return "ORG-"+name.substring(0,3)+phone;
    }
}
