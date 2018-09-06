package by.gsu.epamlab.conntrollers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.dao.IDAOTaskImplementation;
import by.gsu.epamlab.enums.SectionDayEnums;
import by.gsu.epamlab.exception.DAOException;
import by.gsu.epamlab.factory.TaskDAOFactory;
import by.gsu.epamlab.utilit.Constant;
import by.gsu.epamlab.utilit.ServletUtilite;

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
	      response.getWriter().print(jsonArray);
	     // request.setAttribute("section", SectionDayEnums.getValueByParams(request).name());
	      //request.setAttribute(Constant.TASKS, jsonArray);
	     // ServletUtilite.jump(Constant.INDEX_PAGE, request, response);
	    }catch (DAOException e){
	      ServletUtilite.jumpError(Constant.ERROR_KEY_TASK, Constant.INDEX_PAGE, request, response);
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
