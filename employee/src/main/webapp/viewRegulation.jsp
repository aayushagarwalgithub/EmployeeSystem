<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="viewRegulationsForDepartment" >

<div class="form-outline mb-2">
    <label class="form-label">Enter Department for which Regulation is to be viewed</label>
    <input type="text" name="departmentForWhichRegulationIsToBeViewed" class="form-control" required/>    
</div>

<input type="submit" class="btn btn-outline-primary" value="Submit"/>


</form>

</body>
</html>