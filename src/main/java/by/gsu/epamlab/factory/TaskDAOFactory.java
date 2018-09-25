package by.gsu.epamlab.factory;

import java.time.LocalDate;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.dao.DBTaskDAO;
import by.gsu.epamlab.dao.IDAOTaskImplementation;
import by.gsu.epamlab.exception.DAOException;


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
