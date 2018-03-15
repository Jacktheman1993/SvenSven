/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datbase;

/**
 *
 * @author simon
 */
public class DataMapperTest {

    /**
     *
     * @param args
     * vi tester vores forskellige methoder
     */
    public static void main(String[] args)
    {
        DataMapper dm = new DataMapper(new DataSource().getDataSource());
        
        System.out.println("getUsers: " + dm.getUsers());
        System.out.println("getUserByName: " + dm.getUser("Martin"));
//        System.out.println("getUserById: " + dm.getUser(4));
//        System.out.println("createUser: " + dm.createUser(new User(8, "hharlie", "cghh@mail", 50, "1234")));
//        System.out.println("deleteUser: " + dm.deleteUser(7));
//        System.out.println("updateUser: " + dm.updateUser(new User(4, "Bo", "1234@mail.com", 40, "false")));
        System.out.println("validateUser: " + dm.validateUser("Martin", "1234"));
    }
}
