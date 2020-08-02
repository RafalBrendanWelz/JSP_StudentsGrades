package controllers;


import objects.Gender;
import objects.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentAdd")
public class studentAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imie = req.getParameter("imie");
        String nrIndex = req.getParameter("index");
        String nazwisko = req.getParameter("nazwisko");
        String wiek = req.getParameter("wiek");
        String srednia = req.getParameter("srednia");
        String plec = req.getParameter("plec");
        String aktywny = req.getParameter("aktyw");

        student nowyStudent = new student.StudentBuilder()
                .giveImie(imie==null || imie.isEmpty() ? ("brak"):(imie))
                .giveNazwisk(nazwisko==null || nazwisko.isEmpty() ? ("brak"):(nazwisko))
                .giveIndex(nrIndex==null || nrIndex.isEmpty() ? ("brak"):(nrIndex))
                .giveWiek(wiek==null || wiek.isEmpty() ? (0) :(Integer.parseInt(wiek)))
                .givePlec(Gender.valueOf(plec))
                .giveAktywny(aktywny!=null)
                .giveSrednia(srednia==null || srednia.isEmpty() ? (0.0) : (Double.parseDouble(srednia)))
                .build();


        Object obecnaListaStud = req.getSession().getAttribute("studentList");
        List<student> listaStud;
        if (obecnaListaStud instanceof List){
            listaStud = (List<student>) obecnaListaStud;
        }else {
            listaStud = new ArrayList<>();
        }
        listaStud.add(nowyStudent);

        req.getSession().setAttribute("studentList", listaStud);
        resp.sendRedirect("/studentList");
    }





}
