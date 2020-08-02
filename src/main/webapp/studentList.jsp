<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="objects.student" %><%--
  Created by IntelliJ IDEA.
  User: Reginaldo
  Date: 18/07/2020
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      int numbPetli = 1;
    %>

    <table>
        <tr><td>NR</td><td>Index</td><td>Imie</td><td>Nazwisko</td><td>Wiek</td><td>Plec</td><td>Srednia</td><td>Czy_Aktywny</td><td>Delete</td><td>Edit</tr>
        <c:forEach var="student" items="${requestScope.studentList}">
            <tr>
                <td> <% out.print(numbPetli); %></td>
                <td><c:out value="${student.nrIndex}"/></td>
                <td><c:out value="${student.imie}"/></td>
                <td><c:out value="${student.nazwisko}"/></td>
                <td><c:out value="${student.wiek}"/></td>
                <td><c:out value="${student.plec}"/></td>
                <td><c:out value="${student.srednia}"/></td>
                <td><c:out value="${student.aktywny}"/></td>
                <td><a href="/students/studentDeleteHandler.jsp?studentIndex=<c:out value="${student.nrIndex}"/>">Usun</a></td>
                <td><a href="/studentEdit?studentIndex=<c:out value="${student.nrIndex}"/>">Edytuj</a></td>
            </tr>
            <%
                numbPetli++;
            %>
        </c:forEach>
    </table>
    <br><br>
    <jsp:include page="/navigator.jsp"/>
</body>
</html>
