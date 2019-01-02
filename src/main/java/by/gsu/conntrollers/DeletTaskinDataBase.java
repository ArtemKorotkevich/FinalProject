package by.gsu.conntrollers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.gsu.factory.TaskDAOFactory;

@WebServlet("/DeletTaskinDataBase")
public class DeletTaskinDataBase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    TaskDAOFactory
	    .getTaskDAO("db")
	    .deleteTaskInDB(extractPostRequestBody(request));
	}
	private static List<Integer> extractPostRequestBody(HttpServletRequest request)throws IOException {
	    List<Integer>ids = new ArrayList<>();
	    @SuppressWarnings("resource")
	    Scanner sñ = new Scanner(request.getInputStream(),"UTF-8").useDelimiter(",");
	    while(sñ.hasNextLine()){
	      String param = sñ.next();
	      System.out.println(param);
	      int id = Integer.parseInt(param.trim().split("[\\.,\\s!;?:\"']")[1]);
	      ids.add(id); 
	    } 
	    System.out.println(ids);
	    return ids;
	  }

}
