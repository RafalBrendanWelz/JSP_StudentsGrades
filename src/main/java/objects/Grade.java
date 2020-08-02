package objects;

import gradesAutomaticHandlers.GradesIDGiver;
import lombok.Getter;

import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

@Getter
public class Grade {
    private Long id;    // Id is a 6-digit number
    private LocalDateTime dateAdded;
    private Double value;
    private boolean czyPoprawiona;
    private GradeSubject przedmiot;

    public Grade(LocalDateTime dateAdded, Double value, boolean czyPoprawiona, GradeSubject przedmiot) {
        //unique and auto-increasing ID's are handled by GradesIDGiver
        this.id = GradesIDGiver.getINSTANCE().giveNewID();

        this.dateAdded = dateAdded;
        this.value = value;
        this.czyPoprawiona = czyPoprawiona;
        this.przedmiot = przedmiot;
    }




    @Override
    public String toString() {
        String dateShow = dateAdded.format(DateTimeFormatter.ofPattern(String.valueOf(Pattern.compile("dd:MM:YYYY"))));
        String timeShow = dateAdded.format(DateTimeFormatter.ofPattern(String.valueOf(Pattern.compile("hh:mm"))));

        if (czyPoprawiona){
            return "FIX+" + id + " " + przedmiot.getFullname() + ": " + value + " from " + dateShow + " at " + timeShow;
        }else {
            return id + " " + przedmiot.getFullname() + ": " + value + " from " + dateShow + " at " + timeShow;
        }
    }

}
