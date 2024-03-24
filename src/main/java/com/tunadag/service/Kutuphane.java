package com.tunadag.service;

import com.tunadag.model.Kitap;
import com.tunadag.model.Uye;
import com.tunadag.utility.DataImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kutuphane {

    private static final Scanner scanner = new Scanner(System.in);

    private List<Kitap> kitaplar;
    private List<Uye> uyeler;

    public Kutuphane() {
        this.kitaplar = new ArrayList<>();
        this.uyeler = new ArrayList<>();

        DataImpl.populateData(this.kitaplar, this.uyeler);
    }

    public void mainMenu() {
        KitapIslemleri kitapIslemleri = new KitapIslemleri(this.kitaplar);
        UyeIslemleri uyeIslemleri = new UyeIslemleri(this.uyeler);
        OduncIslemleri oduncIslemleri = new OduncIslemleri(this.kitaplar, this.uyeler);
        while (true) {
            System.out.println("");
            System.out.println("## Kütüphane Otomasyon Sistemi");
            System.out.println("**Ana Menü:**");
            System.out.println("**1. Kitap İşlemleri**");
            System.out.println("**2. Üye İşlemleri**");
            System.out.println("**3. Ödünç İşlemleri**");
            System.out.println("**4. Çıkış**");

            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    kitapIslemleri.kitapIslemleriMenu();
                    break;
                case 2:
                    uyeIslemleri.uyeIslemleriMenu();
                    break;
                case 3:
                    oduncIslemleri.oduncIslemleriMenu();
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1 ile 4 arasında bir değer giriniz.");
            }
        }
    }
}

