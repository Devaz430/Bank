<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background: linear-gradient(135deg, #71b7e6, #9b59b6);}
}
.nav_link{
    display: flex;
    justify-content: space-around;
}
.nav_link li a{
    text-decoration: none;
    display: block;
    font-size:30px;
    font-weight: 600;
}
.nav_link li{
    list-style: none;
}

h1{
position: relative;
left: 450px;
top: 200px;
font-size: 60px;
  width: 100%;
}
li{
	list-style-type: none;
	margin: 0;
  padding: 0;
  text-decoration: none;
  display:inline;
}
.a{

padding: 50px;

}

.first{
 position: relative;
    bottom: 200px;
    left: 1000px;
    
    padding: 15px;
    }
    
   
    .second{
 position: relative;
    bottom: 250px;
    left: 1200px;
    
    padding: 15px;
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
<body class="home">
<h1>Welcome to Marwadi Bank</h1>
<div class="nav_link">
<ul>
<li class="a"><a class="admin" href="admin.jsp">Admin</a></li>
<li class="a"><a class="admin" href="user.jsp">User</a></li>
<li class="first"><a href="about.jsp">About</a></li>
<li class="second"><a href="help.jsp">How DO I</a></li>


</ul>
</div>
</body>
</html>
