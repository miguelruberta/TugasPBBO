package com.example.javaapplication.Model.Vendor;

public class Kaos {
    private String tipeKain;
    private String warna;

    public Kaos(){

    }

    public Kaos(String kain,String warna){
        this.tipeKain = kain;
        this.warna = warna;
    }

    public String getTipeKain() {
        return tipeKain;
    }

    public void setTipeKain(String tipeKain) {
        this.tipeKain = tipeKain;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void finalize() throws Throwable {

    }
}
