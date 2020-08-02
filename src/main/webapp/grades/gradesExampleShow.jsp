<%@ page import="objects.Grade" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="objects.GradeSubject" %>
<%--
  Created by IntelliJ IDEA.
  User: Reginaldo
  Date: 02/08/2020
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestOfGradesSystem</title>
</head>
<body>
    <h1>Main showdown of Grades system</h1>

    <%
        Grade test1 = new Grade(LocalDateTime.now(), 3.4, false, GradeSubject.ENG);
        Grade testGrade2 = new Grade(LocalDateTime.now(), 3.2, false, GradeSubject.POL);

        out.print(test1 + " <br>");
        out.print(testGrade2 + " <br>");
    %>

    <jsp:include page="/navigator.jsp"/>
</body>
</html>
