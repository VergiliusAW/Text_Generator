package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Instant starts = Instant.now();
        String inputFileName = "dictionary.txt";
        String outputFileName = "textL.txt";
        List<String> symbols = Arrays.asList(":",";","?","!",",","(",")","'","\"");
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)));
        Dictionary dictionary = new Dictionary(new File(inputFileName));
	    Generator generator = new Generator(dictionary);
        int count = 100000;
        generator.generateText(count,output,symbols);
//        for (String paragraph: generator.generateText(count)) {
//            output.write(paragraph);
//            output.flush();
//        }
        System.out.println(Duration.between(starts, Instant.now()));
    }
}
