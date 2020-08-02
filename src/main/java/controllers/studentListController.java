package controllers;


import objects.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentList")
public class studentListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object studentListResult = req.getSession().getAttribute("studentList");
        List<student> studentList;
        if (studentListResult instanceof List){
            studentList = (List<student>) studentListResult;
        }else {
            studentList = new ArrayList<>();
        }
        req.setAttribute("studentList", studentList);

        req.getRequestDispatcher("/studentList.jsp").forward(req, resp);
    }


}
