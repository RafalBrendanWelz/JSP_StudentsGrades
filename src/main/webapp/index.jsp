
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>Main Index</head>
<body>
<h2>Hello World!</h2>
<%-- przykład komentarza z HTML --%>
<%-- get post put delete --%>
<%
    out.print("Oto Pierwsza Linia <br>");
%>
<h1>Cześć <c:out value="${requestScope.imie}"/></h1>    <%-- póki co nic nie robi bez modyfikacji controllera --%>

<jsp:include page="/navigator.jsp"/>
</body>
</html>
