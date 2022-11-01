<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Displaying Employee Info</h1>
      <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>Employee id</b></th>
          <th><b>Employee name</b></th>
          <th><b>Employee password</b></th>
         </tr>
      
            <tr>
                <td>${bean.eid}</td>
                <td>${bean.name}</td>
                <td>${bean.password}</td>
            </tr>
            
        </table> 
        <hr/>

</body>
</html>