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
/**
* Class for Organizations in the system 
*/

public class Organization {

    private final String orgId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private ArrayList<Task> taskAssigned;
    private ArrayList<Task> taskCompleted;

    /**
     * Creates a new organization with given details
     *
     * @param orgId Unique identifier for the organization
     * @param name Name of the organization
     * @param phone Contact phone number
     * @param email Contact email address
     * @param address Physical address of the organization
     */
    public Organization(String orgId, String name, String phone, String email,
            String address) {
        this.orgId = orgId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        taskAssigned = new ArrayList<>();
        taskCompleted = new ArrayList<>();

    }

    /**
     * Returns the unique organization ID
     *
     * @return the orgId
     */
    public String getOrgId() {
        return this.orgId;
    }

    /**
     * Returns the name of the organization.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the phone number of the organization.
     *
     * @return the phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Returns the email of the organization.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the physical address of the organization.
     *
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns the list of tasks currently assigned to the organization.
     *
     * @return the taskAssigned list
     */
    public ArrayList<Task> getTaskAssigned() {
        return taskAssigned;
    }

    /**
     * Returns the list of tasks completed by the organization.
     *
     * @return the taskCompleted list
     */
    public ArrayList<Task> getTaskCompleted() {
        return taskCompleted;
    }

    /**
     * Updates the name of the organization.
     *
     * @param name The new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Updates the phone number of the organization.
     *
     * @param phone The new phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Updates the email of the organization.
     *
     * @param email The new email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Updates the physical address of the organization.
     *
     * @param address The new address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
