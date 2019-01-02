package by.gsu.conntrollers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import by.gsu.beans.Task;
import by.gsu.beans.User;
import by.gsu.dao.IDAOTaskImplementation;
import by.gsu.enums.SectionDayEnums;
import by.gsu.exception.DAOException;
import by.gsu.factory.TaskDAOFactory;
import by.gsu.utilit.Constant;
import by.gsu.utilit.ServletUtilite;

@WebServlet("/tasks")
public class TasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    final User user = (User) request.getSession().getAttribute(Constant.USER);
	    if(user == null){
	      ServletUtilite.jump(Constant.LOGIN_PAGE, request, response);
	    }
	    System.out.println(user);
	    try{
	      IDAOTaskImplementation tasksSource = TaskDAOFactory.getTaskDAO("db");
	      List<Task> tasksList = tasksSource.getTaskByUser(user, SectionDayEnums.getValueByParams(request));
	      JSONArray jsonArray = new JSONArray(tasksList);
	      System.out.println(jsonArray);
	      response.getWriter().println(jsonArray);
	    }catch (DAOException e){
	      e.printStackTrace();
	      ServletUtilite.jumpError(Constant.ERROR_KEY_TASK, Constant.INDEX_PAGE, request, response);
	    }
	}
}
