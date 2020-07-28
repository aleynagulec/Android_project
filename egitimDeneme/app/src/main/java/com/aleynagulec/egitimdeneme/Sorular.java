package com.aleynagulec.egitimdeneme;

public class Sorular {
    int id;
    String soru;
    String resim;
    int cevap;


    public Sorular(int id, String soru, String resim, int cevap) {
        this.id = id;
        this.soru = soru;
        this.resim = resim;
        this.cevap = cevap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public int getCevap() {
        return cevap;
    }

    public void setCevap(int cevap) {
        this.cevap = cevap;
    }

    public Sorular() {
    }
}
