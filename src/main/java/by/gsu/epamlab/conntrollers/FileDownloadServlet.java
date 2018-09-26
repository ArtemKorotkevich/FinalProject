package by.gsu.epamlab.conntrollers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.exception.DAOException;
import by.gsu.epamlab.utilit.FileHelper;


@WebServlet("/FileDownloadServlet")
@MultipartConfig
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try{
	     PrintWriter printWriter = response.getWriter();
	     int id =  Integer.parseInt(request.getParameter("taskId"));
	     Task task = new Task().setIdtasks(id);
	     String fileName = task.getURL();
	     String realPath = getServletConfig().getServletContext().getRealPath(File.separator);
	     response.setContentType("APPLICATION/OCTET-STREAM");
	     response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	     FileHelper.download(realPath, printWriter, realPath);
	   }catch(DAOException e){
	     e.getMessage();
	   }
	}

}
