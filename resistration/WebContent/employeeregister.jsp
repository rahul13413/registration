<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" required></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" required></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" required></td>
    </tr>
   </table><br>
   <input type="submit" value="Submit" />
   <a href="login.jsp">click here for Login</a>
  </form>
 </div>
</body>
</html>