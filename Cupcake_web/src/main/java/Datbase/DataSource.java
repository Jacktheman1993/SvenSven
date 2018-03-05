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

    import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource
{
    private MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSource()
    {
        dataSource.setServerName("");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("cupcake");
        dataSource.setUser("swoop");
        dataSource.setPassword("airdog86");
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}

