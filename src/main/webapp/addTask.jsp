<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Task</title>
</head>
<body>
	<div class = "addTasks">
<div>
	<h2>add you assignment</h2>
</div>
<form method="post" action="AddTask">
<div>
<h4> date </h4>
<input type="date" name="dateCreate" /><br/>
<h4> date </h4>
<input type="date" name="dateModified" /><br/>
<h4>heading</h4>
<input type="text" name="header" /><br/>
<h4>description</h4>
<textarea  name = "description" rows="15" cols="80"></textarea>
</div>
<div class = "button">
<input type = "submit" value = "send">
<input type = "reset" value =  "clear">
</div>
</form>
</div>
</body>
</html>