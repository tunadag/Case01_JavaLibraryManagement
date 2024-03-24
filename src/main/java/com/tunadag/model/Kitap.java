package com.tunadag.model;
public abstract class Kitap {
    public String ISBN;
    public String baslik;
    public String yazar;
    public int yayinYili;
    public int sayfaSayisi;
    public Durum durum;

    public Kitap(String ISBN, String baslik, String yazar, int yayinYili, int sayfaSayisi) {
        this.ISBN = ISBN;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
        this.sayfaSayisi = sayfaSayisi;
        this.durum = Durum.ODUNCALINABILIR;
    }
    public enum Durum {
        ODUNCALINABILIR, ODUNCTE, MEVCUTDEGIL
    }

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

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
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
