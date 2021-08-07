<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addComment" >

<div class="form-outline mb-2">
    <label class="form-label">Regulation ID</label>
    <input type="text" name="regulationId" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">Username</label>
    <input type="text" name="username" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">Comment</label>
    <input type="text" name="comment" class="form-control" required/>    
</div>

<input type="submit" class="btn btn-outline-primary" value="Add"/>

</form>
<span style="color:red">${requestScope.msg}</span>
</body>
</html>