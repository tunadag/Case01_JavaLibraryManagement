package com.tunadag.model;

public abstract class Kitap {
    private long oid;
    private String ISBN;
    private String baslik;
    private String yazar;
    private int yayinYili;
    private int sayfaSayisi;
    private Durum durum;

    private static long nextOid = 1;

    public Kitap(String ISBN, String baslik, String yazar, int yayinYili, int sayfaSayisi) {
        this.ISBN = ISBN;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
        this.sayfaSayisi = sayfaSayisi;
        this.durum = Durum.ODUNCALINABILIR;
        this.oid = generateNextOid();
    }
    private synchronized static long generateNextOid() {
        return nextOid++;
    }
    public enum Durum {
        ODUNCALINABILIR, ODUNCTE, MEVCUTDEGIL
    }
    public long getOid() { return oid; }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getBaslik() {
        return baslik;
    }
    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }
    public String getYazar() {
        return yazar;
    }
    public void setYazar(String yazar) {
        this.yazar = yazar;
    }
    public int getYayinYili() {
        return yayinYili;
    }
    public void setYayinYili(int yayinYili) {
        this.yayinYili = yayinYili;
    }
    public int getSayfaSayisi() {
        return sayfaSayisi;
    }
    public Durum getDurum() {
        return durum;
    }
    public void setDurum(Durum durum) {
        this.durum = durum;
    }

    public abstract String toString();
    public abstract void oduncVer();
    public abstract void iadeAl();
}
