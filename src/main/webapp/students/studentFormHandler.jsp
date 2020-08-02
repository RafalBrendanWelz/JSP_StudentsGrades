<%--
  Created by IntelliJ IDEA.
  User: Reginaldo
  Date: 18/07/2020
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="objects.Gender" %>
<%@ page import="objects.student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>handler service</title>
</head>
<body>
<%
    // This entire file is unused - dealt by studentAddController
    response.sendRedirect("/studentAdd");

    /*
    String imie = request.getParameter("imie");
    String nrIndex = request.getParameter("index");
    String nazwisko = request.getParameter("nazwisko");
    String wiek = request.getParameter("wiek");
    String srednia = request.getParameter("srednia");
    String plec = request.getParameter("plec");
    String aktywny = request.getParameter("aktyw");


    student nowyStudent = new student.StudentBuilder()
            .giveImie(imie==null || imie.isEmpty() ? ("brak"):(imie))
            .giveNazwisk(nazwisko==null || nazwisko.isEmpty() ? ("brak"):(nazwisko))
            .giveIndex(nrIndex==null || nrIndex.isEmpty() ? ("brak"):(nrIndex))
            .giveWiek(wiek==null || wiek.isEmpty() ? (0) :(Integer.parseInt(wiek)))
            .givePlec(Gender.valueOf(plec))
            .giveAktywny(aktywny!=null)
            .giveSrednia(srednia==null || srednia.isEmpty() ? (0.0) : (Double.parseDouble(srednia)))
            .build();


    Object obecnaListaStud = session.getAttribute("studentList");
    List<student> listaStud;
    if (obecnaListaStud instanceof List){
        listaStud = (List<student>) obecnaListaStud;
    }else {
        listaStud = new ArrayList<>();
    }
    listaStud.add(nowyStudent);

    session.setAttribute("studentList", listaStud);
    response.sendRedirect("/studentList"); //poprzednio adres /studentList.jsp
    */
%>
</body>
</html>
