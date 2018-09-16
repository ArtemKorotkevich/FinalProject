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
import by.gsu.epamlab.factory.TaskDAOFactory;
import by.gsu.epamlab.utilit.Constant;

@WebServlet("/DeleteTasks")
public class DeleteTasks extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    TaskDAOFactory
    .getTaskDAO("db")
    .deleteTaks(getTaskId(request));
    response.sendRedirect(Constant.INDEX_PAGE);
  }

  private static List<Integer> getTaskId(HttpServletRequest request){
    List<Integer>ids = new ArrayList<>();
    Enumeration<String>params = request.getParameterNames();
    while(params.hasMoreElements()){
      String param = params.nextElement();
      if(param.startsWith(param)){
        ids.add(Integer.parseInt(param.split("-")[1]));
      }
    }
    return ids;

  }

}

