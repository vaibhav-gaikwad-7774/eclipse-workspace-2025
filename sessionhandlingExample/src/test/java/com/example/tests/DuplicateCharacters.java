package com.example.tests;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
    public void findDuplicates(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toLowerCase().toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        charCount.forEach((key, value) -> {
            if (value > 1) {
                System.out.println("Character '" + key + "' appears " + value + " times");
            }
        });
    }

    public static void main(String[] args) {
        DuplicateCharacters dc = new DuplicateCharacters();
        dc.findDuplicates("programming");
    }
}