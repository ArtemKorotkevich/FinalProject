<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<form action = "login" method = "post">
		<div class="container-fluid">
			<div class="row">
					<div class = "col-md-3"></div>
						<div class = "col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="jumbotron">
									<h1 class = "text-center">Login Page</h1>
									<br>
									<div class = "form-group">
										<label class="control-lable" for="login">Username</label>
										<input type="text" name="login" class="form-control" placeholder = "Username">
									</div>
										
									<div class = "form-group">
										<label class="control-lable" for="pass">Password</label>
										<input type = "password" name = "pass" class="form-control" placeholder = "password">																				</div>
										<br>
									<div class="pull-right">
										
										<button type="submit" class = "btn btn-outline-dark">Login</button>
									</div>
									<div class="text-center">
										If you are new user, please <a href="register.jsp">register</a>
									</div>
								</div>
						</div>
				</div>
		</div>
	</form>

  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>