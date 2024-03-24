package com.tunadag.model;

public class KitapBilim extends Kitap {
    public KitapBilim(String ISBN, String baslik, String yazar, int yayinYili, int sayfaSayisi) {
        super(ISBN, baslik, yazar, yayinYili, sayfaSayisi);
    }

    @Override
    public String toString() {
        return "KitapBilim{" +
                "ISBN='" + ISBN + '\'' +
                ", baslik='" + baslik + '\'' +
                ", yazar='" + yazar + '\'' +
                ", yayinYili=" + yayinYili +
                ", sayfaSayisi=" + sayfaSayisi +
                ", durum=" + durum +
                '}';
    }

    @Override
    public void oduncVer() {
        if (durum == Durum.MEVCUTDEGIL) {
            System.out.println("Kitap ödünç alınamaz. Mevcut değil.");
        } else if (durum == Durum.ODUNCTE) {
            System.out.println("Kitap ödünç alınamaz. Zaten ödünçte.");
        } else {
            durum = Durum.ODUNCTE;
            System.out.println("Kitap başarıyla ödünç verildi.");
        }
    }

    @Override
    public void iadeAl() {
        if (durum == Durum.MEVCUTDEGIL) {
            System.out.println("Kitap iade edilemez, sistemde mevcut değil.");
        } else if (durum == Durum.ODUNCALINABILIR) {
            System.out.println("Kitap iade edilemez. Zaten kütüphanede.");
        } else {
            durum = Durum.ODUNCALINABILIR;
            System.out.println("Kitap başarıyla iade alındı");
        }
    }
}
