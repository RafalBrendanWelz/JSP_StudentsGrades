<html>
<head>
    <title>Oto Tabliczka Mnożenia</title>
</head>
<body>
<b>Tabliczka Mnozenia</b>

<hr> <%-- ------------------------------------------- --%>
<%-- Tu będzie formularz do podania wartości dla X i Y --%>
<form action="tabMnoz.jsp" method="get">
    Wpisz RozmiarX: <input type="number" min="0" name="rozmiarX"><br/>
    Wpisz RozmiarY: <input type="number" min="0" name="rozmiarY"><br/><br/>
    <input type="button" title="ok">               <%-- przykład przycisku --%>
    <br/><input type="submit">
</form>
<%-- koniec formularza --%>
<br/> <%-- \n --%>
<hr> <%-- ------------------------------------------- --%>

<table>
    <%
        String jakiRozmiarX = request.getParameter("rozmiarX");
        String jakiRozmiarY = request.getParameter("rozmiarY");
        int rozmiarXint;
        int rozmiarY;
        try {
            rozmiarXint = Integer.parseInt(jakiRozmiarX);
        }catch (NumberFormatException e){
            rozmiarXint = 10;
        }
        try {
            rozmiarY = Integer.parseInt(jakiRozmiarY);
        }catch (NumberFormatException e){
            rozmiarY = 10;
        }

        for (int i = 1; i <= rozmiarY; i++) {
            out.print("<tr>");
            for (int j = 1; j <= rozmiarXint; j++) {
                out.print("<td>");
                out.print(i*j);
                out.print("</td>");
            }
            out.print("</tr>");
        }
    %>
</table>
<a href="index.jsp">Powrot</a>
</body>
</html>