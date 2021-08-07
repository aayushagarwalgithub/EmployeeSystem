<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<div class="container">

<form action="loginCheck" method="post">
	<div class="form-outline mb-2">
	    <label class="form-label">username</label>
	    <input type="text" name="username" class="form-control" required/>    
	</div>


	<div class="form-outline mb-2">
	    <label class="form-label">Password</label>
	    <input type="password" name ="password" class="form-control"  required/>
	</div>
 	<label class="form-check-label" for="flexRadioDefault1">Type Of User</label>


	<div class="form-check">
	  <input
	    class="form-check-input"
	    type="radio"
	    name="typeOfUser"
	    value="admin" 
	  />
	  <label class="form-check-label">Admin</label>
	</div>


	<div class="form-check">
	  <input
	    class="form-check-input"
	    type="radio"
	    name="typeOfUser"
	    value="employee"
	  />
	  <label class="form-check-label">Employee</label>
	</div>  


<input type="submit" class="btn btn-outline-primary" value="Sign In"/>

<input type="reset" class ="btn btn-outline-light" value="Reset"/>
</form>


	<span style="color:red">${requestScope.msg}</span>
</div>

</body>
</html>