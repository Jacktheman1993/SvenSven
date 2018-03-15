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
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author The Overlord
 */
public class DBConnector
{
    private DataSource dataSource;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     *
     */
    public DBConnector() {
    }

    /**
     *
     * @param dataSource dataSouse til dataSourse med this
     */
    public DBConnector(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     *
     * @param dataSource setter dataSourse til dataSourse med this
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    /**
     *
     * @throws SQLException kaster Exception på SQL
     */
    public void open() throws SQLException
    {
        if(connection == null || connection.isClosed())
        {
            connection = dataSource.getConnection();
        }
    }
    
    /**
     *
     * @throws SQLException kaster Exception til SQL
     */
    public void close() throws SQLException
    {
        if(resultSet != null)
        {
            resultSet.close();
        }
        
        if(statement != null)
        {
            statement.close();
        }
        
        if(connection != null && !connection.isClosed())
        {
            connection.close();
            connection = null;
        }
    }
    
    /**
     *
     * @param sql
     * Retuner resultet vi får fra executeQuery(sql)
     * @return
     * retuner resultSet
     * @throws SQLException
     * kaster Exception
     */
    public ResultSet executeQuery(String sql) throws SQLException
    {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        
        return resultSet;
    }
    
    /**
     *
     * @param sql
     * vi opdater med executeUpdate(sql)
     * @throws SQLException
     * kaster Exception
     */
    public void executeUpdate(String sql) throws SQLException
    {
        statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
    
    /**
     *
     * @param sql
     * retuner prepareStatment med connection
     * @return
     * retuner prepareStatment
     * @throws SQLException
     * kaster Exceptions
     */
    public PreparedStatement preparedStatement(String sql) throws SQLException
    {
        return connection.prepareStatement(sql);
    }
}