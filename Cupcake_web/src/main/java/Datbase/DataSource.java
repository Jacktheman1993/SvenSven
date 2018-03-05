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
        dataSource.setServerName("207.154.247.203");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("cupcake");
        dataSource.setUser("alek");
        dataSource.setPassword("pyg25ckd");
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}

