/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonnt
 */
public abstract class BaseDAO<T> {
    protected Connection connection;
    public BaseDAO()
    {
        try {
            String user = "sa";
            String pass = "sa";
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=project";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public abstract T get(int id);
    public abstract ArrayList<T> list();
    public abstract void insert(T model);
    public abstract void update(T model);
    public abstract void delete(int id);
           
}
