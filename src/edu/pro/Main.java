package edu.pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static final String HARRY_POTTER_TEXT_PATH_STRING = "src/edu/pro/txt/harry.txt";
    public static final int TOP_WORDS_TO_SHOW = 30;

    public static void main(String[] args) throws IOException {
        LocalDateTime startAppTime = LocalDateTime.now();
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader textReader = Files.newBufferedReader(Paths.get(HARRY_POTTER_TEXT_PATH_STRING), StandardCharsets.ISO_8859_1)) {
            int charByte;
            StringBuilder wordBuilder = new StringBuilder();
            while((charByte = textReader.read()) != -1) { // Read until the end
                if (Character.isAlphabetic(charByte)) {
                    wordBuilder.append((char) Character.toLowerCase(charByte));
                } else if (!wordBuilder.isEmpty()) { // If char is not letter then it is the end of a word
                    wordCount.compute(wordBuilder.toString(), (key, value) -> value == null ? 1 : value + 1);
                    wordBuilder.setLength(0); // Clear wordBuilder
                }
            }
            wordCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(TOP_WORDS_TO_SHOW)
                    .forEach(v -> System.out.println(v.getKey() + " " + v.getValue()));
            LocalDateTime endAppTime = LocalDateTime.now();
            System.out.println("App execution duration: " + ChronoUnit.MILLIS.between(startAppTime, endAppTime) + " milliseconds");
        }
    }
}
