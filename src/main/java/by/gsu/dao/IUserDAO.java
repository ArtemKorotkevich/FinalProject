package by.gsu.dao;

import by.gsu.beans.User;
import by.gsu.exception.DAOException;

public interface IUserDAO {
  public User getUser(String login, String pass)throws DAOException;
  public boolean setUser(User user, String pass)throws DAOException;
  public boolean checkLogin(String login);
}
