package org.wishlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {
        // Percorso del file
        String filePath = "./resources/wishList.txt";

        // Leggi i prodotti dal file
        ArrayList<String> wishList = FileHandler.reader(filePath);

        // Se il file era vuoto o non esisteva, inizializza una nuova lista
        if (wishList == null) {
            wishList = new ArrayList<>();
        }
        boolean choice = true;
        String c;
        String name = null;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Vuoi inserire un prodotto nella lista? (y/n) ");
            c = scanner.nextLine();
            if (Objects.equals(c, "y")) {
                System.out.print("Inserisci l'articolo: ");
                name = scanner.nextLine();
                wishList.add(name);
                System.out.println("Articoli inseriti: " + wishList.size());
            } else if (Objects.equals(c, "n")) {
                choice = false;
            } else {
                System.out.println("Input non valido!");
            }
        } while (choice);
        System.out.println(wishList);
        Collections.sort(wishList);
        FileHandler.writer(wishList, "./resources/wishList.txt");
        System.out.println("Lista ordinata: " + wishList);
    }
}
