package com.tunadag.service;

import com.tunadag.model.Kitap;
import com.tunadag.model.KitapBilim;
import com.tunadag.model.KitapRoman;
import com.tunadag.model.KitapTarih;

import java.util.List;
import java.util.Scanner;

public class KitapIslemleri {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Kitap> kitaplar;

    public KitapIslemleri(List<Kitap> kitaplar) {
        this.kitaplar = kitaplar;
    }

    public void kitapIslemleriMenu() {
        while (true) {
            System.out.println("");
            System.out.println("**Kitap İşlemleri:**");
            System.out.println("**1. Kitap Ekleme**");
            System.out.println("**2. Kitap Silme**");
            System.out.println("**3. Kitap Arama**");
            System.out.println("**4. Mevcut Kitap Listesini Görüntüleme**");
            System.out.println("**5. Geri Dön**");

            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    kitapEkleme();
                    break;
                case 2:
                    kitapSilme();
                    break;
                case 3:
                    kitapAramaMenu();
                    break;
                case 4:
                    kitapListesiGoster();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1 ile 5 arasında bir değer giriniz.");
            }
        }
    }

    private void kitapEkleme() {
        // Kitap türünü seçme
        System.out.println("");
        System.out.println("**Kitap Türü Seçimi:**");
        System.out.println("**1. Roman**");
        System.out.println("**2. Bilim Kurgu**");
        System.out.println("**3. Tarih**");

        System.out.print("Lütfen kitap türünü seçiniz: ");
        int kitapTuruSecim = scanner.nextInt();

        scanner.nextLine();
        // Geçersiz tür seçimini kontrol etme
        if (kitapTuruSecim < 1 || kitapTuruSecim > 3) {
            System.out.println("Hata: Geçersiz kitap türü.");
            return;
        }

        // Kitap bilgilerini kullanıcıdan alma
        System.out.println("");
        System.out.println("**Kitap Ekleme**");
        System.out.print("Kitap ISBN: ");
        String iSBN = scanner.nextLine();
        System.out.print("Kitap Adı: ");
        String kitapAdi = scanner.nextLine();
        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();
        System.out.print("Yayın Yılı: ");
        int yayinYili = scanner.nextInt();
        System.out.print("Sayfa Sayısı: ");
        int sayfaSayisi = scanner.nextInt();

        // Yeni Kitap nesnesi oluşturma
        Kitap kitap = null;
        switch (kitapTuruSecim) {
            case 1:
                kitap = new KitapRoman(iSBN, kitapAdi, yazar, yayinYili, sayfaSayisi);
                break;
            case 2:
                kitap = new KitapBilim(iSBN, kitapAdi, yazar, yayinYili, sayfaSayisi);
                break;
            case 3:
                kitap = new KitapTarih(iSBN, kitapAdi, yazar, yayinYili, sayfaSayisi);
                break;
            default:
                System.out.println("Hata: Geçersiz kitap türü.");
                return;
        }

        // Yeni kitabı listeye ekleme
        kitaplar.add(kitap);

        System.out.println("Kitap başarıyla eklendi: " + kitap);
    }


    public void kitapSilme() {
        // Kullanıcıdan giriş alma
        System.out.println("");
        System.out.print("Silmek istediğiniz kitabın adını veya ISBN numarasını giriniz: ");
        scanner.nextLine();
        String kitapBilgisi = scanner.nextLine();

        // Arama
        Kitap kitap = null;

        if (kitapBilgisi.matches("[0-9]+")) {
            // ISBN numarası ile arama
            kitap = kitapAraISBN(kitapBilgisi);
        } else {
            // Kitap adına göre arama
            kitap = kitapAra(kitapBilgisi);
        }

        // Silme işlemi
        if (kitap != null) {
            kitaplar.remove(kitap);
            System.out.println("**'" + kitap.getBaslik() + "' adlı kitap başarıyla silindi!**");
        } else {
            System.out.println("**'" + kitapBilgisi + "' ile eşleşen bir kitap bulunamadı.**");
        }
    }

    public Kitap kitapAraISBN(String isbn) {
        for (Kitap kitap : kitaplar) {
            if (kitap.getISBN().equals(isbn)) {
                return kitap;
            }
        }
        return null;
    }

    public Kitap kitapAra(String kitapAdi) {
        for (Kitap kitap : kitaplar) {
            if (kitap.getBaslik().equals(kitapAdi)) {
                return kitap;
            }
        }
        return null;
    }

    public void kitapListesiGoster() {
        for (Kitap kitap : kitaplar) {
            System.out.println(kitap.toString());
        }
    }


    private void kitapAramaMenu() {
        while (true) {
            System.out.println("**Kitap Arama:**");
            System.out.println("**1. Kitap Adına Göre Arama**");
            System.out.println("**2. Geri Dön**");

            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Aradığınız kitabın adını giriniz: ");
                    String kitapAdi = scanner.nextLine();
                    Kitap kitap = kitapAra(kitapAdi);
                    if (kitap != null) {
                        System.out.println("**Bulunan Kitap:**");
                        System.out.println(kitap.toString());
                    } else {
                        System.out.println("**'" + kitapAdi + "' adlı kitap bulunamadı.**");
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1 ile 2 arasında bir değer giriniz.");
            }
        }
    }
}
