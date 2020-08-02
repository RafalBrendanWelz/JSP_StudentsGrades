<%@ page import="objects.student" %><%--
  Created by IntelliJ IDEA.
  User: Reginaldo
  Date: 18/07/2020
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Student Form</title>
</head>
<body>
<c:out value="Edytowany = ${sessionScope.studentEdyt.nrIndex}" />
<br>
<form action="${sessionScope.studentEdyt == null ? ("/studentAdd") : ("/studentEdit")}" method="doPost">  <%-- studentFormHandler.jsp --%>
    <input type="hidden" name="edytow" value="${sessionScope.studentEdyt}">

    <label for="index">Index:</label>
    <input type="text" id="index" value="${sessionScope.studentEdyt.nrIndex}" name="index"><br/>

    <label for="imie">FirstName:</label>
    <input type="text" id="imie" value="${sessionScope.studentEdyt.imie}" name="imie"><br/>

    <label for="nazwisko">LastName:</label>
    <input type="text" id="nazwisko" value="${sessionScope.studentEdyt.nazwisko}" name="nazwisko"><br/>

    <label for="srednia">Srednia oceny:</label>
    <input type="number" id="srednia" value="${sessionScope.studentEdyt.srednia}" name="srednia" step="0.01"><br/>

    <label for="wiek">Age:</label>
    <input type="number" id="wiek" value="${sessionScope.studentEdyt.wiek}" name="wiek" step="1"><br/>

    <label for="aktyw">Is Active:</label>
    <input type="checkbox" id="aktyw" value="${sessionScope.studentEdyt.aktywny}" name="aktyw" step="1"><br/>

    <label for="plec">Płeć:</label>
    <select name="plec" id="plec">
        <option name="Male" value="MALE">Male</option>
        <option name="Female" value="FEMALE">Female</option>
        <option name="other" value="DISGUSTING">Weird Shit</option>
    </select>
    <br/>
    <input type="submit">
</form>

<a href="index.jsp">Powrot</a>
</body>
</html>
