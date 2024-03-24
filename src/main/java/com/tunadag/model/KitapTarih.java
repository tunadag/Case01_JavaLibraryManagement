package com.tunadag.model;

public class KitapTarih extends Kitap{
    public KitapTarih(String ISBN, String baslik, String yazar, int yayinYili, int sayfaSayisi) {
        super(ISBN, baslik, yazar, yayinYili, sayfaSayisi);
    }

    @Override
    public String toString() {
        return "KitapRoman{" +
                "oid=" + getOid() +
                ", ISBN='" + getISBN() + '\'' +
                ", baslik='" + getBaslik() + '\'' +
                ", yazar='" + getYazar() + '\'' +
                ", yayinYili=" + getYayinYili() +
                ", sayfaSayisi=" + getSayfaSayisi() +
                ", durum=" + getDurum() +
                '}';
    }
    @Override
    public void oduncVer() {
        if (getDurum() == Durum.MEVCUTDEGIL) {
            System.out.println("Kitap ödünç alınamaz. Mevcut değil.");
        } else if (getDurum() == Durum.ODUNCTE) {
            System.out.println("Kitap ödünç alınamaz. Zaten ödünçte.");
        } else {
            setDurum(Durum.ODUNCTE);
            System.out.println("Kitap başarıyla ödünç verildi.");
        }
    }

    @Override
    public void iadeAl() {
        if (getDurum() == Durum.MEVCUTDEGIL) {
            System.out.println("Kitap iade edilemez, sistemde mevcut değil.");
        } else if (getDurum() == Durum.ODUNCALINABILIR) {
            System.out.println("Kitap iade edilemez. Zaten kütüphanede.");
        } else {
            setDurum(Durum.ODUNCALINABILIR);
            System.out.println("Kitap başarıyla iade alındı");
        }
    }
}
