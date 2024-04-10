<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 10/04/2024
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Student</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/StudentController?action=Create" method="post">
    <label for studentName>Student Name</label>
    <input type="text" name="studentName" id="studentName"/><br>
    <label for age>Age</label>
    <input type="number" name="age" id="age"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" checked/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">Inactive</label><br>
    <input type="submit" value="Create"/>

</form>
</body>
</html>
