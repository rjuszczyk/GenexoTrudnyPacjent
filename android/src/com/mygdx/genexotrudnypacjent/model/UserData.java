package com.mygdx.genexotrudnypacjent.model;

import java.io.Serializable;

/**
 * Created by Radek on 2016-02-27.
 */
public class UserData implements Serializable {
    Row row;
    String imie;
    String nazwisko;
    String telefon;
    String stanowisko;
    public Row getRow() {
        return row;
    }

    public String getEmail() {
        return email;
    }

    public String getCheck1() {
        return check1;
    }

    public String getCheck2() {
        return check2;
    }

    public String getCheck3() {
        return check3;
    }

    String email;
    String check1;
    String check2;
    String check3;

    public String getQuiz_odp1() {
        return quiz_odp1;
    }

    public String getQuiz_odp2() {
        return quiz_odp2;
    }

    public String getQuiz_odp3() {
        return quiz_odp3;
    }

    public void setQuiz_odp1(String quiz_odp1) {
        this.quiz_odp1 = quiz_odp1;
    }

    public void setQuiz_odp2(String quiz_odp2) {
        this.quiz_odp2 = quiz_odp2;
    }

    public void setQuiz_odp3(String quiz_odp3) {
        this.quiz_odp3 = quiz_odp3;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    String quiz_odp1;
    String quiz_odp2;
    String quiz_odp3;

    public void setRow(Row row) {
        this.row = row;
    }

    public void setUserData(String imie, String nazwisko, String telefon, String email, boolean ch1, boolean ch2, boolean ch3) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
        check1 = ch1 ? "tak" : "nie";
        check2 = ch2 ? "tak" : "nie";
        check3 = ch3 ? "tak" : "nie";
    }

    public String toString() {
        return imie + " " + nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }
}
