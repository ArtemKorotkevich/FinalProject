package by.gsu.utilit;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtilite {
  public static String getHashMD5(String str) {
    MessageDigest m;

    try {
      m = MessageDigest.getInstance("MD5");
      m.reset();
      m.update(str.getBytes("utf-8"));
      String s2 = new BigInteger(1, m.digest()).toString(16);
      StringBuilder sb = new StringBuilder(32);

      for (int i = 0, count = 32 - s2.length(); i < count; i++) {
        sb.append("0");
      }
      //return MD5-hash
      return sb.append(s2).toString();

    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      System.err.println("Exception in error when generate MD5!");
      throw new RuntimeException(e);
    }  
  }

  public static void jump(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    RequestDispatcher dispatcher = request.getRequestDispatcher(page); 
    if (dispatcher != null){
      dispatcher.forward(request, response);
    } 
  }

  public static void jumpError(String cause, String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute(cause, cause);
    ServletUtilite.jump(page, request, response);
  }

}
