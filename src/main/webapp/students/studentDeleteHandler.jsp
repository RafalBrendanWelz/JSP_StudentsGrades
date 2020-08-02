<%@ page import="objects.student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Reginaldo
  Date: 19/07/2020
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object studentListResult = session.getAttribute("studentList");
    List<student> studentList;
    if (studentListResult instanceof List){
        studentList = (List<student>) studentListResult;
    }else {
        studentList = new ArrayList<>();
    }

    String nrUsuwanego = request.getParameter("studentIndex");
    out.println("Student o numerze " + nrUsuwanego + " został usuniety");
    for (int i = 0; i < studentList.size(); i++) {
        if (studentList.get(i).getNrIndex().equalsIgnoreCase(nrUsuwanego)){
            studentList.remove(i);
            session.setAttribute("studentList", studentList);
        }
    }
    response.sendRedirect("/studentList");
%>
</body>
</html>
