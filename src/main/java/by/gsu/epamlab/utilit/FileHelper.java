package by.gsu.epamlab.utilit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.http.Part;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.dao.IDAOTaskImplementation;
import by.gsu.epamlab.exception.DAOException;
import by.gsu.epamlab.factory.TaskDAOFactory;

public class FileHelper {
  public static void upload(Task task, Part filePart, String realPath) throws IOException{
        IDAOTaskImplementation taskDAO = TaskDAOFactory.getTaskDAO("db");
    try{
      String fileName= Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
      InputStream fileContent = filePart.getInputStream();
      byte[] byffer = new byte[fileContent.available()];
      fileContent.read(byffer);
      File targetFile = new File(realPath + File.separator + Constant.USER_FILE_FOLDER + File.separator + fileName);
      OutputStream outputStream = new FileOutputStream(targetFile);
      outputStream.write(byffer);
      outputStream.close();
      taskDAO.setFileURLForTask(task, fileName);
    }catch(IOException e){
      throw new DAOException(e.getMessage());
    }
  }

  public void download(String fileName, PrintWriter printWriter, String realPath)throws DAOException{
    try{
      FileInputStream fileInputStream = new FileInputStream(realPath + File.separator + Constant.USER_FILE_FOLDER + File.separator + fileName);
      int buffer;
      while((buffer = fileInputStream.read()) != -1){
        printWriter.write(buffer);
      }
      fileInputStream.close();
      printWriter.close();
    }catch(IOException e){
      throw new DAOException(e.getMessage());
    }
  }

}
