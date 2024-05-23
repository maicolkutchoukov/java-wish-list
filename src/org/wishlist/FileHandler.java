package org.wishlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    // Metodo per scrivere i prodotti su un file
    public static void writer(ArrayList<String> wishList, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String product : wishList) {
                writer.write(product + "\n");
            }
            System.out.println("Prodotti salvati in " + filePath);
        } catch (IOException e) {
            System.out.println("Errore nella scrittura: impossibile scrivere su file");
        }
    }

    // Metodo per leggere i prodotti da un file
    public static ArrayList<String> reader(String filePath) {
        ArrayList<String> wishList = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                wishList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile leggere da " + filePath);
        }
        return wishList;
    }
}
