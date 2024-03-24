package com.tunadag.utility;

import com.tunadag.model.*;

import java.util.List;

public class DataImpl {
    public static void populateData(List<Kitap> kitaplar, List<Uye> uyeler) {
        // Kitap verileri ekleme
        kitaplar.add(new KitapBilim("9780060554736", "Cosmos", "Carl Sagan", 1980, 365));
        kitaplar.add(new KitapBilim("9780345391803", "A Brief History of Time", "Stephen Hawking", 1988, 256));
        kitaplar.add(new KitapTarih("9780684848235", "Guns, Germs, and Steel", "Jared Diamond", 1997, 480));
        kitaplar.add(new KitapTarih("9780375725609", "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2011, 464));
        kitaplar.add(new KitapRoman("9781501173219", "To Kill a Mockingbird", "Harper Lee", 1960, 336));
        kitaplar.add(new KitapRoman("9781400034772", "1984", "George Orwell", 1949, 328));
        kitaplar.add(new KitapBilim("9780590353427", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, 320));
        kitaplar.add(new KitapTarih("9780743246262", "The Diary of a Young Girl", "Anne Frank", 1947, 283));
        kitaplar.add(new KitapRoman("9780141187761", "The Catcher in the Rye", "J.D. Salinger", 1951, 277));
        kitaplar.add(new KitapRoman("9780684801469", "Pride and Prejudice", "Jane Austen", 1813, 279));

        // Üye verileri ekleme
        uyeler.add(new Uye("Ahmet", "Yılmaz"));
        uyeler.add(new Uye("Ayşe", "Kaya"));
        uyeler.add(new Uye("Mehmet", "Demir"));
        uyeler.add(new Uye("Fatma", "Can"));
        uyeler.add(new Uye("Mustafa", "Koc"));
        uyeler.add(new Uye("Emine", "Yıldırım"));
        uyeler.add(new Uye("Ali", "Tuna"));
        uyeler.add(new Uye("Zeynep", "Öztürk"));
        uyeler.add(new Uye("Özlem", "Kara"));
        uyeler.add(new Uye("İbrahim", "Arslan"));
    }
}
