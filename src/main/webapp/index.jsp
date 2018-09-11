<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
							 	<button type="submit" class = "btn btn-outline-orange"><a href= "logout"> Logout </a></button>
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
					onclick='location.href = "addTask.jsp"'/>
					<input id = "todayTasks" type="button" value="Today"/>
					<input id = "tomorrowTasks" type="button" value="Tomorrow"/>
					<input id = "getSomeday" type="button" value="Someday"/>
					<input id = "getfixed" type="button" value="Fixed"/>
					<input id = "getRecycle_bin" type="button" value="Recycle bin"/>
					
					<div id = "contentTask">
						<table class="table table-dark">
							<thead id="tasks">
								<tr>
									<th>description</th>
									<th>date Create</th>
									<th>Date of change</th>
									<th>report</th>
									<th><input type="hidden" name="idtask" value={"$data.idtask"}></th>
								</tr>									
							</thead>
							<tbody id="tasksBody"></tbody>
						</table>
					</div>
	</div>
	<script type="text/javascript">
	<%@include file="/js/script.js"%>
</script>
</body>
</html>