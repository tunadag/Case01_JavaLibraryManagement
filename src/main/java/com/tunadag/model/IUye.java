package com.tunadag.model;

import java.util.List;

public interface IUye {
    String getAd();

    void setAd(String ad);

    String getSoyad();

    void setSoyad(String soyad);

    int getUyeNumarasi();

    void setUyeNumarasi(int uyeNumarasi);

    List<Kitap> getOduncAlinanKitaplar();

    void kitapOduncAl(Kitap kitap);

    void kitapIadeEt(Kitap kitap);
}
