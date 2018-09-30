package by.gsu.epamlab.conntrollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.dao.IUserDAO;
import by.gsu.epamlab.factory.UserDAOFactory;
import by.gsu.epamlab.utilit.Constant;
import by.gsu.epamlab.utilit.ServletUtilite;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletUtilite.jump(Constant.INDEX_PAGE, request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String login = request.getParameter("login");
    String pass = request.getParameter("pass");

    IUserDAO userDAO = UserDAOFactory.getUserDAO("db");

    try{
      System.out.println(login + pass);
      User user = userDAO.getUser(login, pass);

      HttpSession session = request.getSession();
      System.out.println(user.getLogin());
      session.setAttribute(Constant.USER, user);
      ServletUtilite.jump(Constant.INDEX_PAGE, request, response);
    }catch(IllegalArgumentException e){
      ServletUtilite.jumpError(Constant.ERROR_KEY_WHEN_REGISTERED_USER, Constant.LOGIN_PAGE, request, response);
    }
  }

}
