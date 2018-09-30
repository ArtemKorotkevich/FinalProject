package by.gsu.epamlab.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {

  private ConnectionPool(){

  }
  private static ConnectionPool init = null;

  public static ConnectionPool getInstance(){
    if(init ==null){
      init = new ConnectionPool();
    }
    return init;
  }

  public Connection getConnection(){
    Context context;
    Connection connection = null;
    try {
      context = new InitialContext();
      DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/mydatabase");
      connection = ds.getConnection();
    } catch (NamingException e) {
      e.printStackTrace();
    }catch(SQLException e){
      e.printStackTrace();        
    }
    return connection; 
  }
}
