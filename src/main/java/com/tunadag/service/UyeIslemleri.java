package com.tunadag.service;
import com.tunadag.model.Uye;

import java.util.List;
import java.util.Scanner;

public class UyeIslemleri {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Uye> uyeler;

    public UyeIslemleri(List<Uye> uyeler) {
        this.uyeler = uyeler;
    }

    public void uyeIslemleriMenu() {
        while (true) {
            System.out.println("");
            System.out.println("**Üye İşlemleri Menüsü:**");
            System.out.println("**1. Üye Ekle**");
            System.out.println("**2. Üyeleri Listele**");
            System.out.println("**3. Geri**");

            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    uyeEkleme();
                    break;
                case 2:
                    uyeListeleme();
                    break;
                case 3:
                    System.out.println("Ana menüye dönülüyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1 ile 3 arasında bir değer giriniz.");
            }
        }
    }

    private void uyeEkleme() {
        // Üye bilgilerini kullanıcıdan alma
        System.out.println("");
        System.out.println("**Üye Ekleme**");
        System.out.print("Ad: ");
        String ad = scanner.next();
        System.out.print("Soyad: ");
        String soyad = scanner.next();

        // Yeni Üye nesnesi oluşturma ve listeye ekleme
        Uye uye = new Uye(ad, soyad);
        uyeler.add(uye);

        System.out.println("Üye başarıyla eklendi: " + uye);
    }

    private void uyeListeleme() {
        System.out.println("**Üye Listesi**");
        for (Uye uye : uyeler) {
            System.out.println(uye);
        }
    }
}
