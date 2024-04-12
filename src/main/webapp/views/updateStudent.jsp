<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 12/04/2024
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/StudentController?action=Update" method="post">
    <label for studentId>Student ID</label>
    <input type="text" name="studentId" id="studentId" value="${student.studentId}" readonly/><br>
    <label for studentName>Student Name</label>
    <input type="text" name="studentName" id="studentName" value="${student.studentName}"/><br>
    <label for age>Age</label>
    <input type="number" name="age" id="age" value="${student.age}"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" ${student.status?'checked':''}/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false" ${student.status?'':'checked'}/><label for="inActive">Inactive</label><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
