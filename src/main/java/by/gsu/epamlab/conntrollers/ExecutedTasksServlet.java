package by.gsu.epamlab.conntrollers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.gsu.epamlab.exception.DAOException;
import by.gsu.epamlab.factory.TaskDAOFactory;


@WebServlet("/ExecutedTasksServlet")
public class ExecutedTasksServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      TaskDAOFactory
      .getTaskDAO("db")
      .executedTasks(getTasksIds(request));
    } catch (DAOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
  private static List<Integer> getTasksIds(HttpServletRequest request) throws ParseException{
    List<Integer> ids = new ArrayList<>();
    Enumeration<String>params = request.getParameterNames();
    while(params.hasMoreElements()){
      String param = params.nextElement();
      if(param.startsWith("tasks-")){
        ids.add(Integer.parseInt(param.split("-")[1]));
      }
    }
    return ids;
  }
}


