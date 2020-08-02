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


@WebServlet("/studentEdit")
public class studentEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexEdytowanego = req.getParameter("studentIndex");
        if (indexEdytowanego == null || indexEdytowanego.isEmpty()){
            this.doPost(req, resp);
        }

        Object studentListResult = req.getSession().getAttribute("studentList");
        List<student> studentList;
        if (studentListResult instanceof List){
            studentList = (List<student>) studentListResult;
        }else {
            studentList = new ArrayList<>();
        }

        student edytujTego = null;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getNrIndex().equalsIgnoreCase(indexEdytowanego)){
                edytujTego = studentList.get(i);
                break;
            }
        }

        if (edytujTego != null){
            req.getSession().setAttribute("studentEdyt", edytujTego);
            resp.sendRedirect("studentForm.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        student edytowDlaIndex = (student) req.getSession().getAttribute("studentEdyt");

        String imie = req.getParameter("imie");
        String nazwisko = req.getParameter("nazwisko");
        String wiek = req.getParameter("wiek");
        String srednia = req.getParameter("srednia");
        String plec = req.getParameter("plec");
        String aktywny = req.getParameter("aktyw");

        student nowyStudent = new student.StudentBuilder()
                .giveImie(imie==null || imie.isEmpty() ? ("brak"):(imie))
                .giveNazwisk(nazwisko==null || nazwisko.isEmpty() ? ("brak"):(nazwisko))
                .giveIndex(edytowDlaIndex.getNrIndex())
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

        for (int i = 0; i < listaStud.size(); i++) {
            if (listaStud.get(i).getNrIndex().equalsIgnoreCase(nowyStudent.getNrIndex())){
                listaStud.remove(i);
                listaStud.add(nowyStudent);
                break;
            }
        }

        req.getSession().setAttribute("studentEdyt", null);
        req.getSession().setAttribute("studentList", listaStud);
        resp.sendRedirect("/studentList");
    }


}
