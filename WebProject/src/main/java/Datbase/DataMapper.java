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
 */
public class DataMapper implements DataMapperI {

    private DBConnector dbc = new DBConnector();

    public DataMapper(DataSource ds)
    {
        dbc.setDataSource (ds);
    }


 
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
                int user_id = resultset.getInt("user_id");
                String username = resultset.getString("username");
                String email = resultset.getString("email");
                int bal = resultset.getInt("bal");
                String password = resultset.getString("password");

                User u = new User(user_id, username, email, bal, password);

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
                int user_id = resultset.getInt("user_id");
                String username = resultset.getString("username");
                String email = resultset.getString("email");
                int bal = resultset.getInt("bal");
                String password = resultset.getString("password");

                User u = new User(user_id, username, email, bal, password);

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

    @Override
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
                int user_id = resultset.getInt("user_id");
                String username = resultset.getString("username");
                String email = resultset.getString("email");
                int bal = resultset.getInt("bal");
                String password = resultset.getString("password");

                return new User(user_id, username, email, bal, password);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteUser(int id)
    {
        try
        {
            dbc.open();

            String sql = "delete from user where user_id = " + id + ";";
            dbc.executeUpdate(sql);

            sql = "delete from user where user_id = " + id + ";";
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
//
//    @Override
//    public boolean updateUser(User u)
//    {
//        try
//        {
//            dbc.open();
//
//            String sql = "update user from user where id = user_id set "
//                    + "user_id = " + u.getUser_id()
//                    + "username = '" + u.getUsername() + "', "
//                    + "email = '" + u.getEmail() + "', "
//                    + "bal = '" + u.getBal() + "', "
//                    + "password = '" + u.getPassword() + "', "
//                    + "where user_id = " + u.getUser_id();
//                    
//
//            dbc.executeUpdate(sql);
//
//            dbc.close();
//
//            return true;
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//
//        return false;
//    }

    public boolean createUser(User u)
    {
        try
        {
            dbc.open();

            //String sql = "insert into user values(null, "
                    String sql = "insert into user (user_id, username, email, bal, password) values("
                    + "'" + u.getUser_id() + "', "
                    + "'" + u.getUsername() + "', "
                    + "'" + u.getEmail()+ "', "
                    + "'" + u.getBal() + "', "
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
                int id = resultSet.getInt("user_id");
//                boolean admin = resultSet.getInt("admin") > 0;
                String email = resultSet.getString("email");
                int bal = resultSet.getInt("bal");
                user = new User(id, username, email, bal, password);
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
    

