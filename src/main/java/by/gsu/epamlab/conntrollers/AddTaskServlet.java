package by.gsu.epamlab.conntrollers;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.exception.DAOException;
import by.gsu.epamlab.factory.TaskDAOFactory;
import by.gsu.epamlab.utilit.Constant;
import by.gsu.epamlab.utilit.ServletUtilite;

@WebServlet("/AddTask")
public class AddTaskServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
      TaskDAOFactory
      .getTaskDAO("db")
      .addTask(getNewTask(request));
      response.sendRedirect(Constant.INDEX_PAGE);
    }catch(DAOException e){
      ServletUtilite.jumpError(Constant.ERROR_KEY_WHEN_REGISTERED_USER, Constant.INDEX_PAGE, request, response);
    }catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private static Task getNewTask (HttpServletRequest request) throws ParseException{
    return new Task()
        .setUser((User) request.getSession(false).getAttribute(Constant.USER))
        .setDateCreate(LocalDate.parse(request.getParameter("dateCreate")))
        .setDateModified(LocalDate.parse(request.getParameter("dateCreate")))
        .setHeader(request.getParameter("header"))
        .setDescription(request.getParameter("description"));
  }
}
