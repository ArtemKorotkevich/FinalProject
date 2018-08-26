package by.gsu.epamlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.connection.ConnectionPool;
import by.gsu.epamlab.exception.DAOException;
import by.gsu.epamlab.utilit.ServletUtilite;


public class DBUserDAO implements IUserDAO{

  Connection connection = ConnectionPool.getInstance().getConnection();

  @Override
  public User getUser(String login, String pass) throws DAOException {
    String query = "select * from eeproject.user where login=? ;";
    if(checkPassword(login, pass)){
      try{
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
          User user = new User();
          user.setUserId(rs.getInt(1));
          user.setLogin(rs.getString(2));
          user.setEmail(rs.getString(3));
          return user;
        }else{
          throw new NullPointerException("User not faund!");
        }
      }catch(SQLException e){
        throw new DAOException(e);
      }
    }else{
      throw new IllegalArgumentException("password incorect");
    }
    }

    @Override
    public boolean setUser(User user, String pass) throws DAOException {
      String InsertQeryForUser = "insert into eeproject.user"
          +"(`login`, `Email`, `pass`) "
          +"values(?,?,?);";
      PreparedStatement ps = null;
      try{
        ps = connection.prepareStatement(InsertQeryForUser);
        synchronized (ps) {
          ps.setString(1, user.getLogin());
          ps.setString(2, user.getEmail());
          ps.setString(3, ServletUtilite.getHashMD5(pass));
          return ps.execute();
        }
      }catch(SQLException e){
        throw new DAOException(e);
      }
    }

    @Override
    public boolean checkLogin(String login) {
      String checkQuery = "SELECT 'true' FROM eeproject.user WHERE login = \"" + login.trim() + "\";";
      Statement statement = null;
      ResultSet rs = null;
      try{
        boolean result;
        statement = (Statement) ConnectionPool.getInstance().getConnection().createStatement();
        synchronized(this){
          rs = statement.executeQuery(checkQuery);
          result = rs.next()? true: false;
        }
        statement.close();
        rs.close();
        return result;
      }catch(SQLException e){
        throw new DAOException(e);
      }
    }

    public boolean checkPassword(String login, String pass){
      if(checkLogin(login)){
        try{
          String checkQuery = "SELECT pass FROM eeproject.user WHERE login = \"" + login.trim() + "\";";
          Statement statement = null;
          ResultSet rs = null;
          boolean result;

          statement = (Statement) ConnectionPool.getInstance().getConnection().createStatement();
          rs = statement.executeQuery(checkQuery);

          String passFromDB;
          if(rs.next()){
            passFromDB = rs.getString(1);
          }else{
            return false;
          }

          rs.close();
          String hashPass = ServletUtilite.getHashMD5(pass);
          System.out.println(hashPass + " " + passFromDB);
          result = (hashPass.equals(passFromDB.trim())) ? true : false;
          statement.close();
          return result;
        }catch(SQLException e){
          throw new DAOException(e);
        }
      }else{
        throw new IllegalArgumentException("user is null");
      }
    }
  }