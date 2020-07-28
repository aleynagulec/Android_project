package com.aleynagulec.egitimdeneme;

public class eylemler {

    String eylem_no;
    String k_no;
    String eylem_adi;
    String eylem_resim;

    public eylemler(String eylem_no, String k_no, String eylem_adi, String eylem_resim) {
        this.eylem_no = eylem_no;
        this.k_no = k_no;
        this.eylem_adi = eylem_adi;
        this.eylem_resim = eylem_resim;
    }

    public String getEylem_no() {
        return eylem_no;
    }

    public void setEylem_no(String eylem_no) {
        this.eylem_no = eylem_no;
    }

    public String getK_no() {
        return k_no;
    }

    public void setK_no(String k_no) {
        this.k_no = k_no;
    }

    public String getEylem_adi() {
        return eylem_adi;
    }

    public void setEylem_adi(String eylem_adi) {
        this.eylem_adi = eylem_adi;
    }

    public String getEylem_resim() {
        return eylem_resim;
    }

    public void setEylem_resim(String eylem_resim) {
        this.eylem_resim = eylem_resim;
    }

    public eylemler(){

    }
}

