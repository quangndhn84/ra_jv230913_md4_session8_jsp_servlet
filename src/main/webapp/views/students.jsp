<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 10/04/2024
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
  <table border="1">
    <thead>
      <tr>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Age</th>
        <th>Status</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listStudent}" var="student">
        <tr>
          <td>${student.studentId}</td>
          <td>${student.studentName}</td>
          <td>${student.age}</td>
          <td style="color: red">${student.status?"Hoạt động":"Không hoạt động"}</td>
          <td></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="<%=request.getContextPath()%>/views/newStudent.jsp">Create New Student</a>
</body>
</html>
