<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1{
position: relative;
left: 550px;
top: 100px;
font-size: 80px;
}
li{
	list-style-type: none;
	margin: 0;
  padding: 15px;
  text-decoration: none;
  display:inline;
}
.admin{
position: relative;
left: 500px;
display: inline;
top: 200px;
}
.admin:link, .admin:visited {
  background-color: blue;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

.admin:hover, .admin:active {
  background-color: red;
}


</style>
</head>
<body>
<h1>Admin</h1>
<ul>
<li><a class="admin"  href="login.jsp">Login</a></li>
<li><a class="admin"  href="register.jsp">Register</a></li>
</ul>
</body>
</html>