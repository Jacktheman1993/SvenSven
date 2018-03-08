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

    int user_id;
    String username;
    String email;
    int bal;
    String password;
    int count = 0;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int user_id, String username) {
        this.user_id = user_id;
        this.username = username;
    }

    public User(int user_id, String username, String email, int bal, String password) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.bal = bal;
        this.password = password;
    }

    public int getCount() {
        count++;
        return count;

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" + "user_id=" + user_id + ", username=" + username + ", email=" + email + ", bal=" + bal + ", password=" + password + '}';
    }

}
