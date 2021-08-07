<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="deleteEmployee" method="post">

<div class="form-outline mb-2">
    <label class="form-label">username</label>
    <input type="text" name="username" class="form-control" required/>    
</div>

<input type="submit" class="btn btn-outline-primary" value="Account Delete"/>
</form>

	<span style="color:red">${requestScope.msg}</span>

</body>
</html>