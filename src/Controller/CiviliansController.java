/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Civilian;
import Model.StructuralStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/**
 * Controller class responsible for managing Civilians in the system
 */
public class CiviliansController {

    /**
     * Registers a new civilian with the given details and adds them to storage
     * Also adds login credentials for the civilian
     *
     * @param civId the unique ID for the civilian
     * @param name the name of the civilian
     * @param phone the phone number of the civilian
     * @param email the email address of the civilian
     * @param address the address of the civilian
     * @param password the password for the civilian login
     * @throws Exception if a civilian with the same phone number already exists
     */
    public void registerCivilian(String civId, String name, String phone, String email, String address, String password) throws Exception {
        for (Civilian c : StructuralStorage.civilianArrayList) {
            if (c.getPhone().equals(phone)) {
                throw new Exception("A User under the given phone number already exists");
            }
        }
        Civilian civ = new Civilian(civId, name, address, email, phone);
        StructuralStorage.civilianStack.push(civ);
        StructuralStorage.updateCivilianArrayList();
        LoginAndRegistrationController.addCivLoginCred(civId, password);
    }

    /**
     * Generates a new civilian ID based on the given name and a random UUID
     * segment
     *
     * @param name the name of the civilian
     * @return a new unique civilian ID
     */
    public String setCivId(String name) {
        return "CIV-" + name.substring(0, 3) + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }

    /**
     * Returns the ArrayList of all civilians currently in storage
     *
     * @return the ArrayList of civilians
     */
    public static ArrayList<Civilian> getCivilianAL() {
        return Model.StructuralStorage.civilianArrayList;
    }

    /**
     * Updates the information of an existing civilian identified by ID
     *
     * @param id the civilian ID to update
     * @param name the new name
     * @param email the new email
     * @param phone the new phone
     * @param address the new address
     */
    public static void updateCivs(String id, String name, String email, String phone, String address) {
        for (Civilian c : StructuralStorage.civilianStack) {
            if (c.getCivId().equals(id)) {
                c.setAddress(address);
                c.setEmail(email);
                c.setName(name);
                c.setPhone(phone);
            }
        }
        StructuralStorage.updateCivilianArrayList();
    }

    /**
     * Removes the civilian identified by the given ID from storage
     *
     * @param id the civilian ID to remove
     * @throws Exception if no civilian exists with the given ID
     */
    public static void removeCiv(String id) throws Exception {
        Iterator<Civilian> iter = StructuralStorage.civilianStack.iterator();
        while (iter.hasNext()) {
            Civilian c = iter.next();
            if (c.getCivId().equals(id)) {
                iter.remove();
                StructuralStorage.updateCivilianArrayList();
                return;
            }
        }
        throw new Exception("Invalid User Id");
    }

    /**
     * Removes the most recently added civilian from storage.
     */
    public static void removeRecentlyAdded() {
        StructuralStorage.civilianStack.pop();
        StructuralStorage.updateCivilianArrayList();
    }
}
