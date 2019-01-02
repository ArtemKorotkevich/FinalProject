package by.gsu.beans;

public class User {
  private int UserId;
  private String login;
  private String email;

  public int getUserId() {
    return UserId;
  }

  public String getLogin() {
    return login;
  }

  public String getEmail() {
    return email;
  }

  public void setUserId(int userId) {
    UserId = userId;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User() {
    super();
  }

  public User(int userId, String login, String email) {
    super();
    UserId = userId;
    this.login = login;
    this.email = email;
  }

  @Override
  public String toString() {
    return "User [UserId=" + UserId + ", login=" + login + ", email=" + email + "]";
  }  
}
