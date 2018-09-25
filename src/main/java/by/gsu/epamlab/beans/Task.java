package by.gsu.epamlab.beans;

import java.time.LocalDate;

public class Task {
  private User user;
  private int idtasks;
  private LocalDate dateCreate;
  private LocalDate dateModified;
  private String header;
  private String description;
  private boolean report;
  private boolean recycleBin;
  private String URL;

  public User getUser() {
    return user;
  }

  public int getIdtasks() {
    return idtasks;
  }

  public LocalDate getDateCreate() {
    return dateCreate;
  }

  public LocalDate getDateModified() {
    return dateModified;
  }

  public String getHeader() {
    return header;
  }

  public String getDescription() {
    return description;
  }

  public boolean isReport() {
    return report;
  }

  public boolean isRecycleBin() {
    return recycleBin;
  }
  public String  getURL(){
    return URL;
  }

  public Task setUser(User user) {
    this.user = user;
    return this;
  }

  public Task setIdtasks(int idtasks) {
    this.idtasks = idtasks;
    return this;
  }

  public Task setDateCreate(LocalDate dateCreate) {
    this.dateCreate = dateCreate;
    return this;
  }

  public Task setDateModified(LocalDate dateModified) {
    this.dateModified = dateModified;
    return this;
  }

  public Task setHeader(String header) {
    this.header = header;
    return this;
  }

  public Task setDescription(String description) {
    this.description = description;
    return this;
  }

  public Task setReport(boolean report) {
    this.report = report;
    return this;
  }

  public Task setRecycleBin(boolean recycleBin) {
    this.recycleBin = recycleBin;
    return this;
  }
  
  public Task setURL(String url){
    this.URL = url;
    return this;
  }

  public Task() {
    super();
  }

  public Task(User user, int idtasks, LocalDate dateCreate, LocalDate dateModified, String header,
      String description, boolean report, boolean recycleBin, String url) {
    super();
    this.user = user;
    this.idtasks = idtasks;
    this.dateCreate = dateCreate;
    this.dateModified = dateModified;
    this.header = header;
    this.description = description;
    this.report = report;
    this.recycleBin = recycleBin;
    this.URL = url;
  }

  @Override
  public String toString() {
    return "Task [user=" + user + ", idtasks=" + idtasks + ", dateCreate=" + dateCreate
        + ", dateModified=" + dateModified + ", header=" + header + ", description=" + description
        + ", report=" + report + ", recycleBin=" + recycleBin + "url = " + URL+ "]";
  }








}
