package by.gsu.exception;

public class DAOException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DAOException (String message){
    super(message);
  }

  public DAOException (Throwable cause){
    super(cause + "" + cause.getMessage());
  }

  public DAOException(String string, Exception e){
    super(string, e);
  }
}
