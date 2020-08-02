package objects;


import lombok.Getter;

@Getter
public enum GradeSubject {
    ENG("English"),
    POL("Polish"),
    IT("Informatics"),
    MATH("Mathematics");

    private final String fullname;

    GradeSubject(String fullname) {
        this.fullname = fullname;
    }


}
