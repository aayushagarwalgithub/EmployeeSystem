<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="deleteDepartment" >

<div class="form-outline mb-2">
    <label class="form-label">Enter Department ID</label>
    <input type="text" name="departmentId" class="form-control" required/>    
</div>

<input type="submit" class="btn btn-outline-primary" value="Submit"/>

</form>

<span style="color:red">${requestScope.msg}</span>
</body>
</html>