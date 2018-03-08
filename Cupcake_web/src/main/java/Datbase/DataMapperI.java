/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datbase;

import Datbase.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author simon
 */
public interface DataMapperI {
//   public ArrayList<User> getTeamMembers(int team_id);
//    public ArrayList<Team> getTeams();
//    public Team getTeam(int id);
//    public Team getTeam(String teamname);
    public ArrayList<User> getUsers();
    public ArrayList<User> getUsers(String username);
//    public User getUser(int id);
    public User getUser(String username);
    public boolean deleteUser(String username);
    public boolean updateUser(User u);
    public boolean createUser(User u);
}
