<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addRegulationsForDepartment" >

<div class="form-outline mb-2">
    <label class="form-label">Enter Department for which Regulation is to be added</label>
    <input type="text" name="departmentForWhichRegulationsIsToBeAdded" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">Enter Regulation</label>
    <input type="text" name="regulationName" class="form-control" required/>    
</div>

<div class="form-outline mb-2">
    <label class="form-label">Enter Regulation Id</label>
    <input type="text" name="regulationId" class="form-control" required/>    
</div>

<input type="submit" class="btn btn-outline-primary" value="Submit"/>

	
</form>

<span style="color:red">${requestScope.msg}</span>
</body>
</html>