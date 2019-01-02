package by.gsu.factory;

import by.gsu.beans.User;
import by.gsu.dao.DBUserDAO;
import by.gsu.dao.IUserDAO;
import by.gsu.dao.RAMUserDAO;
import by.gsu.exception.DAOException;

public class UserDAOFactory {
 private UserDAOFactory() {}
  
  public static IUserDAO getUserDAO(String type) throws DAOException{
    switch (type){
      case "ram":
        return new RAMUserDAO();
       case "db":
           return new DBUserDAO();
       default:
         throw new DAOException("type of DAO is not found");
    }
  }
  public static User getUserFromFactory(String login, String email){
    User user = new User();
    user.setLogin(login);
    user.setEmail(email);
    return user;
  }

}
