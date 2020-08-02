package gradesAutomaticHandlers;


import objects.Grade;
import objects.student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GradeGiveHandler extends HttpServlet {
    private static GradeGiveHandler INSTANCE;
    private String lastID;              //IDs are 6-digit 5 for grade plus last digit is number of correction
    // test idea... not used right now


    public GradeGiveHandler(String lastID) {
        this.lastID = lastID;
    }
    public GradeGiveHandler() {
    }

    public static GradeGiveHandler getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new GradeGiveHandler("000010");
            return INSTANCE;
        }else {
            return INSTANCE;
        }
    }

    public void findGrade(final Long ID, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obecnaListaGrade = req.getSession().getAttribute("gradeList");
        List<Grade> listaGrade;
        if (obecnaListaGrade instanceof List){
            listaGrade = (List<Grade>) obecnaListaGrade;
            Optional<Grade> znaleziona = listaGrade.stream()
                    .filter( grade -> grade.getId()==ID )
                    .findFirst();

            if (znaleziona.isPresent()){
                resp.sendRedirect(req.getPathInfo()+"?ID="+ID );
            }
        }
        resp.sendRedirect(req.getPathInfo());
    }


}
