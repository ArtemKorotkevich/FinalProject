package by.gsu.epamlab.dao;

import java.util.List;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.enums.SectionDayEnums;
import by.gsu.epamlab.exception.DAOException;

public interface IDAOTaskImplementation {
  
  public List<Task> getTaskByUser (User user, SectionDayEnums sectionDayEnums)throws DAOException;
  public boolean addTask(Task task)throws DAOException;
  public void deleteTaks (List<Integer> list)throws DAOException;
  public void executedTasks(List<Integer> list)throws DAOException;
  public void deleteTaskInDB(List<Integer> list)throws DAOException;
  public void setFileURLForTask(Task task, String fileName)throws DAOException;
}
