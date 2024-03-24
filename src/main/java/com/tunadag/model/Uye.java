package com.tunadag.model;

import java.util.ArrayList;
import java.util.List;

public class Uye implements IUye{
    private String ad;
    private String soyad;
    private int uyeNumarasi;
    private List<Kitap> oduncAlinanKitaplar;

    public Uye(String ad, String soyad, int uyeNumarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.uyeNumarasi = uyeNumarasi;
        this.oduncAlinanKitaplar = new ArrayList<>();
    }

    @Override
    public String getAd() {
        return ad;
    }

    @Override
    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String getSoyad() {
        return soyad;
    }

    @Override
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Override
    public int getUyeNumarasi() {
        return uyeNumarasi;
    }

    @Override
    public void setUyeNumarasi(int uyeNumarasi) {
        this.uyeNumarasi = uyeNumarasi;
    }

    @Override
    public List<Kitap> getOduncAlinanKitaplar() {
        return oduncAlinanKitaplar;
    }

    @Override
    public void kitapOduncAl(Kitap kitap) {
        oduncAlinanKitaplar.add(kitap);
    }

    @Override
    public void kitapIadeEt(Kitap kitap) {
        oduncAlinanKitaplar.remove(kitap);
    }

    @Override
    public String toString() {
        return "Uye{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", uyeNumarasi=" + uyeNumarasi +
                ", oduncAlinanKitaplar=" + oduncAlinanKitaplar +
                '}';
    }
}
