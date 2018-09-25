package by.gsu.epamlab.conntrollers;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.exception.DAOException;
import by.gsu.epamlab.utilit.Constant;
import by.gsu.epamlab.utilit.FileHelper;

@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
      HttpSession session =request.getSession();
      List<Task> tasks = (List<Task>) session.getAttribute(Constant.TASKS);
      Part filePart = request.getPart("file");
      System.out.println(filePart);
      String  id = request.getParameter("taskId");
      System.out.println(id);
      String realPath = getServletConfig().getServletContext().getRealPath(File.separator);
      System.out.println(realPath);
      System.out.println(tasks.get(Integer.parseInt(id)) + " " + tasks);
      FileHelper.upload(tasks.get(Integer.parseInt(id)), filePart, realPath);
      
      response.sendRedirect(Constant.INDEX_PAGE);
    }catch(DAOException e){
      e.printStackTrace();
    }
  }
}