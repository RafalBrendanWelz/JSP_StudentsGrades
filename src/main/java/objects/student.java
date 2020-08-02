package objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class student {
    private String imie;
    private String nazwisko;
    private String nrIndex;
    private int wiek;
    private Gender plec;
    private double srednia;
    private boolean aktywny;

    public student(String imie, String nazwisko, String nrIndex, int wiek, Gender plec, double srednia, boolean aktywny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndex = nrIndex;
        this.wiek = wiek;
        this.plec = plec;
        this.srednia = srednia;
        this.aktywny = aktywny;
    }



    public static class StudentBuilder{
        String imie;
        String nazwisko;
        String nrIndex;
        int wiek;
        Gender plec;
        double srednia;
        boolean aktywny;

        public StudentBuilder() {
            this.imie = "imie";
            this.nazwisko = "nazwisko";
            this.nrIndex = "00000000";
            this.wiek = 20;
            this.plec = Gender.MALE;
            this.srednia = 3.2;
            this.aktywny = true;
        }

        public StudentBuilder giveImie(final String imie){
            this.imie = imie;
            return this;
        }
        public StudentBuilder giveNazwisk(final String nazwisko){
            this.nazwisko = nazwisko;
            return this;
        }
        public StudentBuilder giveIndex(final String nrIndex){
            this.nrIndex = nrIndex;
            return this;
        }
        public StudentBuilder giveWiek(final int wiek){
            this.wiek = wiek;
            return this;
        }
        public StudentBuilder givePlec(final Gender plec){
            this.plec = plec;
            return this;
        }
        public StudentBuilder giveSrednia(final double srednia){
            this.srednia = srednia;
            return this;
        }
        public StudentBuilder giveAktywny(final boolean akty){
            this.aktywny = akty;
            return this;
        }

        public StudentBuilder giveImie(){
            return this;
        }
        public StudentBuilder giveNazwisk(){
            return this;
        }
        public StudentBuilder giveIndex(){
            return this;
        }
        public StudentBuilder giveWiek(){
            return this;
        }
        public StudentBuilder giveSrednia(){
            return this;
        }

        public student build(){
            return new student(imie,nazwisko,nrIndex,wiek,plec,srednia,aktywny);
        }
    }

}
