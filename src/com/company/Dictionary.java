package com.company;

import javax.swing.text.Element;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {

    private List<String> dictionary = new ArrayList<>();

    /**
     * One word = one line
     * @param file
     */
    public Dictionary(File file) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            dictionary = input.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param list
     */
    public Dictionary(List<String> list) {

    }

    public void addToDictionary(String word) {
        if (!dictionary.contains(word)) {
            dictionary.add(word);
        } else {
            System.out.println(String.format("Word %s is already in dictionary",word));
        }
    }

    public void removeFromDictionary(String word) {
        if (dictionary.contains(word)) {
            dictionary.remove(word);
            System.out.println(String.format("Word %s has been removed from dictionary",word));
        } else {
            System.out.println(String.format("Word %s is already in dictionary",word));
        }
    }

    public List<String> getDictionary() {
        return dictionary;
    }

    public String getRandomWord() {
        return dictionary.get(Math.abs(new Random().nextInt()%dictionary.size()));
    }
}
