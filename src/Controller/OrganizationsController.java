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
 * Controller class responsible for managing organizations in the system
 */
public class OrganizationsController {

    /**
     * Registers a new organization with the given details and stores login
     * credentials
     *
     * @param orgId the unique organization ID
     * @param name the organization name
     * @param phone the organization phone number
     * @param email the organization email
     * @param address the organization address
     * @param password the password for login
     * @throws Exception if a user with the same phone number already exists
     */
    public void registerOrganization(String orgId, String name, String phone, String email, String address, String password) throws Exception {
        for (Organization o : StructuralStorage.organizationArrayList) {
            if (o.getPhone().equals(phone)) {
                throw new Exception("A User under the given phone number already exists");
            }
        }
        Organization org = new Organization(orgId, name, phone, email, address);
        StructuralStorage.organizationStack.push(org);
        StructuralStorage.updateOrganizationArrayList();
        LoginAndRegistrationController.addOrgLoginCred(orgId, password);
    }

    /**
     * Generates a new organization ID based on the name and a random UUID
     *
     * @param name the name of the organization
     * @return a unique organization ID
     */
    public String setOrgId(String name) {
        return "ORG-" + name.substring(0, 3) + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }

    /**
     * Retrieves the ArrayList of all organizations
     *
     * @return an ArrayList containing all organizations
     */
    public static ArrayList<Organization> getOrganizationAL() {
        return Model.StructuralStorage.organizationArrayList;
    }

    /**
     * Updates an existing organization's details based on its ID
     *
     * @param id the ID of the organization to update
     * @param name the new name
     * @param email the new email
     * @param phone the new phone number
     * @param address the new address
     */
    public static void updateOrgs(String id, String name, String email, String phone, String address) {
        for (Organization o : StructuralStorage.organizationStack) {
            if (o.getOrgId().equals(id)) {
                o.setAddress(address);
                o.setEmail(email);
                o.setName(name);
                o.setPhone(phone);
            }
        }
        StructuralStorage.updateOrganizationArrayList();
    }

    /**
     * Removes an organization from storage based on its ID
     *
     * @param id the ID of the organization to remove
     * @throws Exception if the organization ID is invalid
     */
    public static void removeOrg(String id) throws Exception {
        Iterator<Organization> iter = StructuralStorage.organizationStack.iterator();
        while (iter.hasNext()) {
            Organization o = iter.next();
            if (o.getOrgId().equals(id)) {
                iter.remove(); // safe removal
                StructuralStorage.updateOrganizationArrayList();
                return;
            }
        }

        throw new Exception("Invalid User ID");
    }

    /**
     * Removes the most recently added organization from storage
     */
    public static void removeRecentlyAdded() {
        StructuralStorage.organizationStack.pop();
        StructuralStorage.updateOrganizationArrayList();
    }

    /**
     * Retrieves the list of tasks in progress for the given organization
     *
     * @param sessionUser the organization ID to retrieve tasks for
     * @return an ArrayList of tasks currently assigned to the organization
     */
    public static ArrayList<Task> getOrgTIPList(String sessionUser) {
        for (Organization o : StructuralStorage.organizationStack) {
            if (o.getOrgId().equalsIgnoreCase(sessionUser)) {
                return o.getTaskAssigned();
            }
        }
        return new ArrayList();
    }

    /**
     * Retrieves the list of completed tasks for the given organization
     *
     * @param sessionUser the organization ID to retrieve tasks for
     * @return an ArrayList of tasks completed by the organization
     */
    public static ArrayList<Task> getOrgComTaskList(String sessionUser) {
        for (Organization o : StructuralStorage.organizationStack) {
            if (o.getOrgId().equalsIgnoreCase(sessionUser)) {
                return o.getTaskCompleted();
            }
        }
        return new ArrayList();
    }

    /**
     * Marks a task as completed by the given organization Moves the task from
     * assigned to completed lists and updates system-wide task lists
     *
     * @param o the organization completing the task
     * @param t the task to mark as completed
     */
    public static void markTaskComplete(Organization o, Task t) {
        t.setCompletedBy(LoginAndRegistrationController.sessionUser);
        o.getTaskAssigned().remove(t);
        o.getTaskCompleted().add(t);
        TaskController.getTaskIPAL().remove(t);
        TaskController.getComTaskAL().add(t);
    }
}
