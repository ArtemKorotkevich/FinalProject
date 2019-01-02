package by.gsu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import by.gsu.beans.Task;
import by.gsu.beans.User;
import by.gsu.enums.SectionDayEnums;
import by.gsu.epamlab.connection.ConnectionPool;
import by.gsu.exception.DAOException;
import by.gsu.factory.TaskDAOFactory;

public class DBTaskDAO implements IDAOTaskImplementation {

  private Connection connection;
  private static final Object LOCK = new Object(); // object monitor

  public  DBTaskDAO() {
    this.connection = ConnectionPool.getInstance().getConnection();
  }

  @Override
  public boolean addTask(Task task) throws DAOException {
    String InsertQeryForTask = "insert into eeproject.tasks (UserId, dateCreate, dateModified,"
        + " header, description)values(?,?,?,?,?);";
    try{
      PreparedStatement ps = connection.prepareStatement(InsertQeryForTask);
      synchronized (LOCK) {
        ps.setInt(1, task.getUser().getUserId());
        ps.setDate(2, Date.valueOf(task.getDateCreate()));
        ps.setDate(3, Date.valueOf(task.getDateModified()));
        ps.setString(4, task.getHeader());
        ps.setString(5, task.getDescription());
        return ps.execute();        
      }
    }catch (SQLException e){
      throw new DAOException(e);
    }finally {
      try{
        if(connection!=null){
          connection.close();
        }
      }catch(SQLException e){
        e.printStackTrace();
      }
    }
  }

  @Override
  public void deleteTaks(List<Integer> list) throws DAOException {
    String deleteQeryForTasks = "UPDATE eeproject.tasks SET recycle_Bin = 1 WHERE idtasks = ?;";

    try{
      PreparedStatement ps = connection.prepareStatement(deleteQeryForTasks);
      for(int ids: list){
        synchronized (LOCK) {
          ps.setInt(1, ids);
          ps.execute();
        }
      }
    }catch(SQLException e){
      throw new  DAOException(e);
    }
  }

  @Override
  public void executedTasks(List<Integer> list) throws DAOException {
    String executedQeryForTasks = "UPDATE eeproject.tasks SET report = 1 WHERE idtasks = ?;";
    try{
      PreparedStatement ps = connection.prepareStatement(executedQeryForTasks);
      for(int ids: list){
        synchronized (LOCK) {
          ps.setInt(1, ids);
          ps.execute();
        }
      }
    }catch(SQLException e){
      throw new DAOException(e);
    }finally {
      try{
        if(connection != null){
          connection.close();
        }
      }catch(SQLException e){
        e.printStackTrace();
      }
    }
  }

  @Override
  public void deleteTaskInDB(List<Integer> list) throws DAOException {
    String deleteQeryForTasks = "DELETE FROM `eeproject`.`tasks` WHERE `idtasks`=?;";
    try{
      PreparedStatement ps = connection.prepareStatement(deleteQeryForTasks);
      for(int ids: list){
        synchronized (LOCK) {
          ps.setInt(1, ids);
          ps.execute();
        }
      }
    }catch(SQLException e){
      throw new DAOException(e);
    }
  }

  @Override
  public List<Task> getTaskByUser(User user, SectionDayEnums sectionDayEnums) throws DAOException {
    if(Objects.isNull(user)){
      throw new IllegalArgumentException("User is null");
    }
    ResultSet rs = null;
    List<Task> userList = new ArrayList<>();
    try{
      rs = connection.createStatement().executeQuery(sectionDayEnums.getQuerery(user));
      while(rs.next()){
        userList.add(TaskDAOFactory.getTasksFromFactory(user, rs.getInt("idtasks"), rs.getDate("dateCreate").toLocalDate(),
            rs.getDate("dateModified").toLocalDate(), rs.getString("header"), rs.getString("description"), rs.getBoolean("report"), rs.getBoolean("recycle_Bin"),rs.getString("url")));
      }
      return userList;
    }catch(SQLException e){
      throw new DAOException(e);
    }finally {
      try{
        if(connection != null){
          connection.close();
        }
      }catch(SQLException e){
        e.printStackTrace();
      }
    }
  }

  @Override
  public void setFileURLForTask(Task taskId, String fileName) throws DAOException {
    String Update = "UPDATE eeproject.tasks SET url = ? WHERE idtasks = ?;";
    PreparedStatement ps = null;
    try{
      ps = connection.prepareStatement(Update);
      synchronized (LOCK) {
        ps.setString(1, taskId.getURL()); 
        ps.setInt(2, taskId.getIdtasks());
        ps.execute();
      }
    }catch(SQLException e){
      throw new DAOException(e);
    }
  }

}