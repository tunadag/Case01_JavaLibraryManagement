package com.tunadag.service;

import com.tunadag.model.Kitap;
import com.tunadag.model.Uye;

import java.util.ArrayList;
import java.util.List;

public class Kutuphane {
    private List<Kitap> kitaplar;
    private List<Uye> uyeler;

    public Kutuphane() {
        this.kitaplar = new ArrayList<>();
        this.uyeler = new ArrayList<>();
    }

    public void kitapEkle(Kitap kitap) {
        kitaplar.add(kitap);
    }

    public void kitapSil(Kitap kitap) {
        kitaplar.remove(kitap);
    }


    public void kitapOduncAl(Uye uye, Kitap kitap) {
        if (kitap.getDurum() == Kitap.Durum.MEVCUTDEGIL) {
            System.out.println("Kitap ödünç alınamaz. Mevcut değil.");
        } else if (kitap.getDurum() == Kitap.Durum.ODUNCTE) {
            System.out.println("Kitap ödünç alınamaz. Zaten ödünçte.");
        } else {
            kitap.oduncVer();
            uye.kitapOduncAl(kitap);
            System.out.println("Kitap başarıyla üyeye ödünç verildi.");
        }
    }

    public void kitapIadeEt(Uye uye, Kitap kitap) {
        if (kitap.getDurum() == Kitap.Durum.MEVCUTDEGIL) {
            System.out.println("Kitap iade edilemez. Mevcut değil.");
        } else if (kitap.getDurum() == Kitap.Durum.ODUNCALINABILIR) {
            System.out.println("Kitap iade edilemez. Zaten kütüphanede.");
        } else {
            kitap.iadeAl();
            uye.kitapIadeEt(kitap);
            System.out.println("Kitap başarıyla kütüphaneye iade alındı.");
        }
    }
}
