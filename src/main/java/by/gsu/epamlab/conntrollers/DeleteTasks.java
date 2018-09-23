package by.gsu.epamlab.conntrollers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.mapper.Mapper;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.mysql.fabric.xmlrpc.base.Params;
import by.gsu.epamlab.exception.DAOException;
import by.gsu.epamlab.factory.TaskDAOFactory;
import by.gsu.epamlab.utilit.Constant;

@WebServlet("/DeleteTasks")
public class DeleteTasks extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      TaskDAOFactory
      .getTaskDAO("db")
      .deleteTaks(extractPostRequestBody(request));
    } catch (DAOException e) {
      e.printStackTrace();
    }
  }

  private static List<Integer> extractPostRequestBody(HttpServletRequest request)throws IOException {
    List<Integer>ids = new ArrayList<>();
    @SuppressWarnings("resource")
    Scanner sñ = new Scanner(request.getInputStream(),"UTF-8").useDelimiter(",");
    while(sñ.hasNextLine()){
      String param = sñ.next(); 
      int id = Integer.parseInt(param.trim().split("[\\.,\\s!;?:\"']")[1]);
      ids.add(id); 
    } 
    return ids;
  }
}




