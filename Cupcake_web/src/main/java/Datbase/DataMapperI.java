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

    /**
     *
     * @return
     */
    public ArrayList<User> getUsers();

    /**
     *
     * @param username
     * @return
     */
    public ArrayList<User> getUsers(String username);
//    public User getUser(int id);

    /**
     *
     * @param username
     * @return
     */
    public User getUser(String username);

    /**
     *
     * @param username
     * @return
     */
    public boolean deleteUser(String username);

    /**
     *
     * @param u
     * @return
     */
    public boolean updateUser(User u);

    /**
     *
     * @param u
     * @return
     */
    public boolean createUser(User u);
}
