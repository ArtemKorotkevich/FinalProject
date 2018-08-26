package by.gsu.epamlab.conntrollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.dao.IUserDAO;
import by.gsu.epamlab.factory.UserDAOFactory;
import by.gsu.epamlab.utilit.Constant;
import by.gsu.epamlab.utilit.ServletUtilite;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletUtilite.jump(Constant.INDEX_PAGE, request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
    IUserDAO userDAO = UserDAOFactory.getUserDAO("db");
    User newUser = UserDAOFactory.getUserFromFactory(request.getParameter(Constant.LOGIN),
        request.getParameter(Constant.EMAIL));
    if(userDAO.checkLogin(newUser.getLogin())){
      ServletUtilite.jumpError(Constant.ERROR_KEY_WHEN_REGISTERED_USER, Constant.REGISTER_PAGE,
          request, response);
      return;
    }

    userDAO.setUser(newUser, request.getParameter(Constant.PASSWORD));
    response.sendRedirect(Constant.INDEX_PAGE);

  }
}

