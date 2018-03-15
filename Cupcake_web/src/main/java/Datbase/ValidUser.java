/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datbase;

/**
 *
 * @author Alek
 */
public class ValidUser {
    
   String username;
   String password;

    /**
     *
     * @param username
     * sætter username med username med this
     * @param password
     * sætter passeword med password med this
     */
    public ValidUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     * returner username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * settet username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * retuner password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * settet password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ValidUser{" + "username=" + username + ", password=" + password + '}';
    }
   
   
}
