package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    private Dictionary dictionary;

    public Generator() {

    }

    public Generator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String generateSentence(List<String> symbols) {
        StringBuilder builder = new StringBuilder();
        int length = (new Random().nextInt()+1)%14;
        for (int i=0;i<length;i++) {
            if (new Random().nextInt()%10==0)
                builder.append(dictionary.getRandomWord()+symbols.get(Math.abs(new Random().nextInt()% symbols.size()))+" ");
            else
                builder.append(dictionary.getRandomWord()+" ");
        }
        builder.append(dictionary.getRandomWord()+".");
        return builder.toString();
    }

    public String generateSimpleSentence() {
        StringBuilder builder = new StringBuilder();
        int length = (new Random().nextInt()+1)%14;
        for (int i=0;i<length;i++) {
            builder.append(dictionary.getRandomWord()+" ");
        }
        builder.append(dictionary.getRandomWord()+".");
        return builder.toString();
    }

    public String generateSimpleOneLineParagraph() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append(generateSimpleSentence());
        }
        return builder.toString();
    }

    public String generateOneLineParagraph(List<String> symbols) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append(generateSentence(symbols));
        }
        return builder.toString();
    }

    /**
     * Сгенерировать текст из произвольного количества
     * абзацев со стандартным предложений в абзаце
     * @param count количество абзацев
     * @return список абзацев
     */
    public List<String> generateText(int count) {
        List<String> text = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            text.add(generateSimpleOneLineParagraph()+"\n");
        }
        return text;
    }

    public void generateText(int count, BufferedWriter output) {
        for (int i = 0; i < count; i++) {
            try {
                output.write(generateSimpleOneLineParagraph()+"\n");
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Генерирует текст в файл
     * @param count
     * @param output
     * @param symbols
     */
    public void generateText(int count, BufferedWriter output, List<String> symbols) {
        for (int i = 0; i < count; i++) {
            try {
                output.write(generateOneLineParagraph(symbols)+"\n");
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
