<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>you page</title>
</head>
<body>
<style><%@include file="/css/dopstyle.css"%></style>
	<div class = "container">
			<div class = "row">
						<div class ="col-md-12 head-block">
							<div class = "text">
								<h2>do not forget about your affairs!</h2>
							</div>
							
							 <div class="pull-right">
							 	<button type="submit" class="btn btn-primary"><a href= "logout">  Logout </a></button>
								 	</div>
								 		<div class="user">
								 		<h3>hello ${user.login}|</h3>
							 			</div>
						</div>
					</div>
			</div>
	</div>
<div class="container">
		<input type="button" value="add task"
					onclick='location.href = "addTask.jsp"' class="btn btn-primary"/>
					<input id = "todayTasks" type="button" value="Today" class="btn btn-primary"/>
					<input id = "tomorrowTasks" type="button" value="Tomorrow" class="btn btn-primary"/>
					<input id = "somedayTasks" type="button" value="Someday" class="btn btn-primary"/>
					<input id = "fixedTasks" type="button" value="Fixed" class="btn btn-primary"/>
					<input id = "recycle_binTasks" type="button" value="Recycle Bin" class="btn btn-primary" />
					
					<div id = "contentTask">
						<table class="table table-dark">
							<thead id="tasks">
								<tr>
									<th>#</th>
									<th>header</th>
									<th>description</th>
									<th>date Create</th>
									<th>Date of change</th>
									<th>report</th>
								</tr>									
							</thead>
							<tbody id = "tasksBody"></tbody>
						</table>
					</div>
					
					
				 <input id = "delInDB" type ="button" value="delet of recycli bin" class="btn btn-danger"/>
					<input id = "delete" type="button" value="delete" class="btn btn-primary" />
					<input id = "excuted" type="button" value="excuted"class="btn btn-primary" />

	</div>
	<script type="text/javascript">
	<%@include file="/js/script.js"%>
</script>
</body>
</html>