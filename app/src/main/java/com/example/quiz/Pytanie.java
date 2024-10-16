package com.example.quiz;

public class Pytanie {
    private String tresc;
    private String podpowiedz;
    private boolean poprawna;
    private boolean udzielonoPoprawnaOdpowiedz;
    private int idObrazka;

    public int getIdObrazka() {
        return idObrazka;
    }

    public Pytanie(String tresc, String podpowiedz, boolean poprawna, int idObrazka) {
        this.tresc = tresc;
        this.podpowiedz = podpowiedz;
        this.poprawna = poprawna;
        this.idObrazka = idObrazka;
    }

    public Pytanie(String tresc, String podpowiedz, boolean poprawna) {
        this.tresc = tresc;
        this.podpowiedz = podpowiedz;
        this.poprawna = poprawna;
        udzielonoPoprawnaOdpowiedz = false;
    }

    public void setUdzielonoPoprawnaOdpowiedz(boolean udzielonoPoprawnaOdpowiedz) {
        this.udzielonoPoprawnaOdpowiedz = udzielonoPoprawnaOdpowiedz;
    }

    public String getTresc() {
        return tresc;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public boolean isPoprawna() {
        return poprawna;
    }

    public boolean isUdzielonoPoprawnaOdpowiedz() {
        return udzielonoPoprawnaOdpowiedz;
    }
}
