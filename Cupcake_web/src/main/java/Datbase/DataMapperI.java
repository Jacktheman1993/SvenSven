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
     * retuner getUsers
     */
    public ArrayList<User> getUsers();

    /**
     *
     * @param username
     * String username
     * @return
     * retuner getUsers
     */
    public ArrayList<User> getUsers(String username);
//    public User getUser(int id);

    /**
     *
     * @param username
     * string username
     * @return
     * retuner getUser
     */
    public User getUser(String username);

    /**
     *
     * @param username
     * string username
     * @return
     * retuner deleteUser
     */
    public boolean deleteUser(String username);

    /**
     *
     * @param u
     * String username u
     * @return
     * retuner updateUser
     */
    public boolean updateUser(User u);

    /**
     *
     * @param u
     * User u
     * @return
     * retuner createUser
     */
    public boolean createUser(User u);
}
