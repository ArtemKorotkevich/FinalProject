package by.gsu.factory;

import java.time.LocalDate;
import by.gsu.beans.Task;
import by.gsu.beans.User;
import by.gsu.dao.DBTaskDAO;
import by.gsu.dao.IDAOTaskImplementation;
import by.gsu.exception.DAOException;


public class TaskDAOFactory {
  public static IDAOTaskImplementation getTaskDAO(String type) throws DAOException{
    switch(type){
      case "db":
        return new DBTaskDAO();
      default:
        throw new DAOException("Type of IDAOTaskImplementation is not found");
    }
  }

  public static Task getTasksFromFactory(User user, int idtasks, LocalDate dateCreate, LocalDate dateModified,String header,String description,boolean report,boolean recycle_Bin, String url){
    return new Task()
        .setUser(user)
        .setIdtasks(idtasks)
        .setDateCreate(dateCreate)
        .setDateModified(dateModified)
        .setHeader(header)
        .setDescription(description)
        .setReport(report)
        .setRecycleBin(recycle_Bin)
        .setURL(url);
  }
}
