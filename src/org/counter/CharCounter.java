package org.counter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una parola: ");
        String word = scanner.nextLine();

        countCharacters(word);
    }

    public static void countCharacters(String word) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Conta le occorrenze di ogni carattere
        for (char c : word.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Stampa le occorrenze
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

