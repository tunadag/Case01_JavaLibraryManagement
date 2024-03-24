package com.tunadag.service;

import com.tunadag.model.Kitap;
import com.tunadag.model.Uye;

import java.util.List;
import java.util.Scanner;

public class OduncIslemleri {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Kitap> kitaplar;
    private List<Uye> uyeler;

    public OduncIslemleri(List<Kitap> kitaplar, List<Uye> uyeler) {
        this.kitaplar = kitaplar;
        this.uyeler = uyeler;
    }

    public void oduncIslemleriMenu() {
        while (true) {
            System.out.println("");
            System.out.println("**Ödünç İşlemleri Menüsü:**");
            System.out.println("**1. Üyeye Ödünç Ver**");
            System.out.println("**2. Üyeden İade Al**");
            System.out.println("**3. Kitap Durumunu Güncelle**");
            System.out.println("**4. Üyenin Ödünç Aldığı Kitapları Görüntüle**");
            System.out.println("**5. Geri**");

            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    kitapOduncVer();
                    break;
                case 2:
                    kitapIadeAl();
                    break;
                case 3:
                    kitapDurumuGuncelle();
                    break;
                case 4:
                    uyeninOduncAldigiKitaplariGoruntule();
                    break;
                case 5:
                    System.out.println("Ana menüye dönülüyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1 ile 5 arasında bir değer giriniz.");
            }
        }
    }

    private void kitapOduncVer() {
        System.out.print("Üye numarasını girin: ");
        int uyeNumarasi = scanner.nextInt();
        System.out.print("Ödünç verilecek kitabın oid'sini girin: ");
        long kitapOid = scanner.nextLong();

        Uye uye = null;
        Kitap kitap = null;
        for (Uye u : uyeler) {
            if (u.getUyeNumarasi() == uyeNumarasi) {
                uye = u;
                break;
            }
        }
        for (Kitap k : kitaplar) {
            if (k.getOid() == kitapOid) {
                kitap = k;
                break;
            }
        }

        if (uye == null) {
            System.out.println("Hata: Belirtilen üye numarasıyla kayıtlı bir üye bulunamadı.");
            return;
        }
        if (kitap == null) {
            System.out.println("Hata: Belirtilen oid numarasıyla kayıtlı bir kitap bulunamadı.");
            return;
        }

        if (kitap.getDurum() == Kitap.Durum.ODUNCALINABILIR) {
            uye.kitapOduncAl(kitap);
            kitap.setDurum(Kitap.Durum.ODUNCTE);
            System.out.println("Kitap başarıyla ödünç verildi.");
        } else {
            System.out.println("Hata: Belirtilen kitap şu anda ödünç alınamaz durumda.");
        }
    }

    private void kitapIadeAl() {
        System.out.print("Üye numarasını girin: ");
        int uyeNumarasi = scanner.nextInt();
        System.out.print("İade edilecek kitabın oid'ini girin: ");
        long kitapOid = scanner.nextLong();

        Uye uye = null;
        Kitap kitap = null;
        for (Uye u : uyeler) {
            if (u.getUyeNumarasi() == uyeNumarasi) {
                uye = u;
                break;
            }
        }
        for (Kitap k : kitaplar) {
            if (k.getOid() == kitapOid) {
                kitap = k;
                break;
            }
        }

        if (uye == null) {
            System.out.println("Hata: Belirtilen üye numarasıyla kayıtlı bir üye bulunamadı.");
            return;
        }
        if (kitap == null) {
            System.out.println("Hata: Belirtilen oid numarasıyla kayıtlı bir kitap bulunamadı.");
            return;
        }

        if (uye.getOduncAlinanKitaplar().contains(kitap)) {
            uye.kitapIadeEt(kitap);
            kitap.setDurum(Kitap.Durum.ODUNCALINABILIR);
            System.out.println("Kitap başarıyla iade alındı.");
        } else {
            System.out.println("Hata: Belirtilen üyenin ödünç aldığı kitaplar arasında belirtilen kitap bulunamadı.");
        }
    }

    private void kitapDurumuGuncelle() {
        System.out.print("Güncellenecek kitabın oid'ini girin: ");
        long kitapOid = scanner.nextLong();

        Kitap kitap = null;
        for (Kitap k : kitaplar) {
            if (k.getOid() == kitapOid) {
                kitap = k;
                break;
            }
        }

        if (kitap == null) {
            System.out.println("Hata: Belirtilen oid numarasıyla kayıtlı bir kitap bulunamadı.");
            return;
        }

        System.out.println("Lütfen yeni durumu seçin:");
        System.out.println("1. Ödünç alınabilir");
        System.out.println("2. Ödünçte");
        System.out.println("3. Mevcut değil");
        System.out.print("Seçiminizi yapın (1-3): ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 1:
                kitap.setDurum(Kitap.Durum.ODUNCALINABILIR);
                break;
            case 2:
                kitap.setDurum(Kitap.Durum.ODUNCTE);
                break;
            case 3:
                kitap.setDurum(Kitap.Durum.MEVCUTDEGIL);
                break;
            default:
                System.out.println("Hata: Geçersiz seçim.");
                return;
        }
        System.out.println("Kitap durumu başarıyla güncellendi.");
    }

    private void uyeninOduncAldigiKitaplariGoruntule() {
        System.out.print("Üye numarasını girin: ");
        int uyeNumarasi = scanner.nextInt();

        Uye uye = null;
        for (Uye u : uyeler) {
            if (u.getUyeNumarasi() == uyeNumarasi) {
                uye = u;
                break;
            }
        }

        if (uye == null) {
            System.out.println("Hata: Belirtilen üye numarasıyla kayıtlı bir üye bulunamadı.");
            return;
        }

        System.out.println("Üyenin ödünç aldığı kitaplar:");
        List<Kitap> oduncAldigiKitaplar = uye.getOduncAlinanKitaplar();
        if (oduncAldigiKitaplar.isEmpty()) {
            System.out.println("Üye henüz hiç kitap ödünç almamış.");
        } else {
            for (Kitap kitap : oduncAldigiKitaplar) {
                System.out.println(kitap);
            }
        }
    }


}
