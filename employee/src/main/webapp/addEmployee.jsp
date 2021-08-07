<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="container">
<form action="createEmployee" method="get">

<div class="form-outline mb-2">
    <label class="form-label">firstname</label>
    <input type="text" name="firstname" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">lastname</label>
    <input type="text" name="lastname" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">dob</label>
    <input type="text" name="dob" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">email</label>
    <input type="text" name="email" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">department id</label>
    <input type="text" name="department_id" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">Username</label>
    <input type="text" name="username" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">password</label>
    <input type="text" name="password" class="form-control" required/>    
</div>


<input type="submit" class="btn btn-outline-primary" value="Account Create"/>

</form>

<span style="color:red">${requestScope.msg}</span>

</div>

</body>
</html>