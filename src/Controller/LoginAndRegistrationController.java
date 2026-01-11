/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Admin;
import Model.LoginCredentials;

/**
 * Controller class responsible for handling login and registration
 * functionality for Admins, Organizations, and Civilians
 */
public class LoginAndRegistrationController {

    public static String sessionUser;

    /**
     * Authenticates an admin user based on provided username and password Sets
     * the session user if authentication is successful
     *
     * @param username the admin username
     * @param password the admin password
     * @return true if authentication is successful
     * @throws Exception if username or password is incorrect
     */
    public static boolean adminAuthenticate(String username, String password) throws Exception {
        Admin a = new Admin();
        if (username.equals(a.getUsername()) && password.equals(a.getPassword())) {
            sessionUser = username;
            return true;
        }
        throw new Exception("Incorrect Username or Password");
    }

    /**
     * Authenticates an admin user based on provided username and password Sets
     * the session user if authentication is successful
     *
     * @param username the admin username
     * @param password the admin password
     * @return true if authentication is successful
     * @throws Exception if username or password is incorrect
     */
    public static boolean orgAuthenticate(String username, String password) throws Exception {
        if ((getOrgLoginCred(username)).equals(password)) {
            sessionUser = username;
            return true;
        }
        throw new Exception("Incorrect Username or Password");

    }

    /**
     * Authenticates a civilian user based on provided username and password
     * Sets the session user if authentication is successful
     *
     * @param username the civilian username
     * @param password the civilian password
     * @return true if authentication is successful
     * @throws Exception if username or password is incorrect
     */
    public static boolean civAuthenticate(String username, String password) throws Exception {
        if ((getCivLoginCred(username)).equals(password)) {
            sessionUser = username;
            return true;
        }
        throw new Exception("Incorrect Username or Password");

    }

    /**
     * Adds login credentials for a new civilian user
     *
     * @param username the civilian username
     * @param password the civilian password
     */
    public static void addCivLoginCred(String username, String password) {
        LoginCredentials.civLoginCred.put(username, password);
    }

    /**
     * Adds login credentials for a new organization user
     *
     * @param username the organization username
     * @param password the organization password
     */
    public static void addOrgLoginCred(String username, String password) {
        LoginCredentials.orgLoginCred.put(username, password);
    }

    /**
     * Retrieves the password associated with the given organization username
     *
     * @param username the organization username
     * @return the stored password, or null if username does not exist
     */
    public static String getOrgLoginCred(String username) {
        return LoginCredentials.orgLoginCred.get(username);
    }

    /**
     * Retrieves the password associated with the given civilian username
     *
     * @param username the civilian username
     * @return the stored password, or null if username does not exist
     */
    public static String getCivLoginCred(String username) {
        return LoginCredentials.civLoginCred.get(username);
    }

    /**
     * Ends the current user session by clearing the session user.
     */
    public static void endUserSession() {
        sessionUser = null;
    }
}
