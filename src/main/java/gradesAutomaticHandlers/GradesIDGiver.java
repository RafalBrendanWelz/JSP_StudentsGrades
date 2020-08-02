package gradesAutomaticHandlers;


import objects.Grade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class GradesIDGiver {
    private static GradesIDGiver INSTANCE;
    private String lastID;              //IDs are 6-digit 5 for grade plus last digit is number of correction


    public GradesIDGiver(String lastID) {
        this.lastID = lastID;
    }
    public GradesIDGiver() {
    }

    public static GradesIDGiver getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new GradesIDGiver("100010");
            return INSTANCE;
        }else {
            return INSTANCE;
        }
    }

    public Long giveNewID(){
        Long IDwithIncrement = Long.parseLong(lastID) + 10L;
        lastID = String.valueOf(IDwithIncrement);
        if (IDLengthChecking(lastID)){
            return Long.valueOf(lastID);
        }else {
            return Long.valueOf("100010");
        }
    }
    private boolean IDLengthChecking(final String idToCheck){
        return idToCheck.length()==6;
    }


    public void redirectWithID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getPathInfo()+"?ID="+this.giveNewID());
    }
    public void redirectWithID(final Long porawiaOceneOID, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obecnaListaGrade = req.getSession().getAttribute("gradeList");
        List<Grade> listaGrade;

        Long sourceGradeID = giveSourceGradeID(porawiaOceneOID);

        if (obecnaListaGrade instanceof List){
            listaGrade = (List<Grade>) obecnaListaGrade;
            Optional<Grade> znaleziona = listaGrade.stream()
                    .filter( grade -> grade.getId().equals(sourceGradeID))
                    .findFirst();

            if (znaleziona.isPresent()){
                resp.sendRedirect(req.getPathInfo()+"?ID="+sourceGradeID );
                // wysyła nowe id jako argument dla strony pytającej
            }
        }
        resp.sendRedirect(req.getPathInfo());
    }


    private Long giveSourceGradeID(final Long porawiaOceneOID){
        if (checkIfIDCorrectLength(porawiaOceneOID)) {
            String certainCorrectID;

            if (String.valueOf(porawiaOceneOID).length() == 6){
                certainCorrectID = String.valueOf(porawiaOceneOID).substring(0, 6)+"0";
            }else {
                certainCorrectID = porawiaOceneOID +"0";
            }
            return Long.valueOf(certainCorrectID);
        }else {
            throw new IllegalArgumentException("ID's of grades have to be 6-digit number");
        }
    }
    private boolean checkIfIDCorrectLength(Long porawiaOceneOID) {
        return List.of(5,6).contains(String.valueOf(porawiaOceneOID).length());
    }


}
