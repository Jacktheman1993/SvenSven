/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datbase;

/**
 *
 * @author alle sammen her
 */
public class User {

//    int user_id;
    String username;
//    String email;
//    int bal;
    String password;
//    int count = 0;

    /**
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     * retuner username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * setter username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * returner password
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
        return "User{" + "username=" + username + ", password=" + password + '}';
    }
    
}
