/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datbase;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author The Overlord
 */
public class DataMapper implements DataMapperI {

    private DBConnector dbc = new DBConnector();

    /**
     *
     * @param ds
     * settet DataSourse med dbc
     */
    public DataMapper(DataSource ds)
    {
        dbc.setDataSource (ds);
    }

    /**
     * settet en ny ArrayList op med users
     * åbner dbc
     * køre igennem, hvor vi tage alle user fra databasen
     * settet resultset med dbc.executeQuery(sql)
     * laver while loop
     * laver String med username
     * laver String med password
     * laver et nyt object med user
     * lukker dbc
     * catcher exception 
     * @return
     * retuner users
     */
    @Override
    public ArrayList<User> getUsers()
    {
        ArrayList<User> users = new ArrayList();

        try
        {
            dbc.open();

            String sql = "select * from user";
            ResultSet resultset = dbc.executeQuery(sql);
            while (resultset.next())
            {
//                int user_id = resultset.getInt("user_id");
                String username = resultset.getString("username");
//                String email = resultset.getString("email");
//                int bal = resultset.getInt("bal");
                String password = resultset.getString("password");

                User u = new User(username, password);

                users.add(u);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    /**
     *
     * @param un
     * laver Arraylist med String un
     * dbc open
     * laver sql med hvor alt i user bliver hentet fra databasen
     * laver string med user og password som er i  et while loop
     * laver et nyt objest med user
     * added user
     * lukker dbc
     * catcher exception
     * @return
     * retuner users
     */
    @Override
    public ArrayList<User> getUsers(String un)
    {
        ArrayList<User> users = new ArrayList();

        try
        {
            dbc.open();

            String sql = "select * from user where username like '%" + un + "%'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                String username = resultset.getString("username");
                String password = resultset.getString("password");

                User u = new User(username, password);

                users.add(u);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    /*@Override
    public User getUser(int id)
    {
        User q = null;
        User u = null;
        
        try
        {
            dbc.open();

            String sql = "select user_id, username from user where user_id = " + id;
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                int user_id = resultset.getInt("user_id");
                String username = resultset.getString("username");
//                String email = resultset.getString("email");
//                int bal = resultset.getInt("bal");
//                String password = resultset.getString("password");
                u = new User(user_id, username);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return u;
    }
*/

    /**
     *
     * @param name
     * dbc open
     * sql med alt fra user hvor user er lige med username
     * laver strng med username og password i et while loop
     * retuner ny user
     * catcher exception 
     * @return
     * retuner null
     */

    @Override
    public User getUser(String name)
    {
        try
        {
            dbc.open();

            String sql = "select * from user where username = '" + name + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                String username = resultset.getString("username");
                String password = resultset.getString("password");

                return new User(username, password);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param username
     * dbc open
     * laver string sql hvor der bliver slettet hvor username er lige med username, hvor der blever kørt dbc.executeQuery(sql)
     * lukker dbc
     * retuner true
     * catcher exception 
     * @return
     * retuner false
     */
    @Override
    public boolean deleteUser(String username)
    {
        try
        {
            dbc.open();

            String sql = "delete from user where username = " + username + ";";
            dbc.executeUpdate(sql);

            sql = "delete from user where username = " + username + ";";
            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    /**
     *
     * @param u
     * dbc open
     * string sql hvor der bliver opdateret user mae username og password
     * køre dbc executeUpdate(sql)
     * lukker dbc
     * retuner true
     * catcher exception 
     * @return
     * retuner false
     */
    @Override
    public boolean updateUser(User u)
    {
        try
        {
            dbc.open();

            String sql = "update user from user where username = username set "
                    + "username = '" + u.getUsername() + "', "
                    + "password = '" + u.getPassword() + "', "
                    + "where username = " + u.getUsername();
                    

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    /**
     *
     * @param u
     * String sql, hvor der bliver indsat ind i user med username og password
     * køre dbc executeUpdate
     * lukker dbc
     * retuner true
     * catcher Exception
     * @return
     * retuner false
     */
    public boolean createUser(User u)
    {
        try
        {
            dbc.open();

            //String sql = "insert into user values(null, "
                    String sql = "insert into user (username, password) values("
                    + "'" + u.getUsername() + "', "
                    + "'" + u.getPassword()+"'" + ")";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    
    /**
     * string sql hvor alt bliver tagwt fra user hvor username og password er lige med ?
     * der bliver kørt en prepared statment med sql
     * @param username
     * @param password
     * køre prepared stastment med setString username
     * køre prepared statement med setString password
     * sætter resultSet lige med preparedStatement.
     * køre if med ny user
     * lukker bdc
     * catcher exception
     * @return
     * retuner user
     */
    public User validateUser(String username, String password)
    {
        User user = null;
        
        try
        {
            dbc.open();
            
            /*
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            System.out.println("SQL: " + sql);
            ResultSet resultSet = dbc.executeQuery(sql);
            */
            
            //PreparedStatement
            String sql = "select * from user where username = ? and password = ?";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next())
            {
//                boolean admin = resultSet.getInt("admin") > 0;
                user = new User(username, password);
            }

            dbc.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return user;
    }
    
//       @Override
//    public ArrayList<Team> getTeams()
//    {
//        ArrayList<Team> teams = new ArrayList();
//
//        try
//        {
//            dbc.open();
//
//            String sql = "select * from team";
//            ResultSet resultset = dbc.executeQuery(sql);
//
//            while (resultset.next())
//            {
//                int teamid = resultset.getInt("team_id");
//                String teamname = resultset.getString("teamname");
//
//                Team t = new Team(teamid, teamname);
//
//                teams.add(t);
//            }
//
//            dbc.close();
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//
//        return teams;
//    }

//    @Override
//    public Team getTeam(int id)
//    {
//        try
//        {
//            dbc.open();
//
//            String sql = "select * from team where team_id = " + id;
//            ResultSet resultset = dbc.executeQuery(sql);
//
//            if (resultset.next())
//            {
//                int teamid = resultset.getInt("team_id");
//                String teamname = resultset.getString("teamname");
//
//                return new Team(teamid, teamname);
//            }
//
//            dbc.close();
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public Team getTeam(String name)
//    {
//        try
//        {
//            dbc.open();
//
//            String sql = "select * from team where teamname = '" + name + "'";
//            ResultSet resultset = dbc.executeQuery(sql);
//
//            if (resultset.next())
//            {
//                int teamid = resultset.getInt("team_id");
//                String teamname = resultset.getString("teamname");
//
//                return new Team(teamid, teamname);
//            }
//
//            dbc.close();
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//        @Override
//    public ArrayList<User> getTeamMembers(int team_id)
//    {
//        ArrayList<User> users = new ArrayList();
//
//        try
//        {
//            dbc.open();
//
//            String sql = "select * from user, team_user where user.user_id = team_user.user_id and team_user.team_id = " + team_id;
//            ResultSet resultset = dbc.executeQuery(sql);
//
//            while (resultset.next())
//            {
//                int userid = resultset.getInt("user.user_id");
//                String username = resultset.getString("username");
//                String userpassword = resultset.getString("password");
//                boolean admin = resultset.getBoolean("admin");
//
//                User u = new User(userid, username, userpassword, admin);
//
//                users.add(u);
//            }
//
//            dbc.close();
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//
//        return users;
//    }


    }
    

