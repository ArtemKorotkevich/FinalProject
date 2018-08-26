package by.gsu.epamlab.dao;

import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.exception.DAOException;

public interface IUserDAO {
  public User getUser(String login, String pass)throws DAOException;
  public boolean setUser(User user, String pass)throws DAOException;
  public boolean checkLogin(String login);
}
