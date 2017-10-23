import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\input.txt";
        String outputPath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\output.txt";
        HashMap<String, Integer> wordCount = new LinkedHashMap<>();
        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            while (scanner.hasNextLine()) {
                Scanner tempScanner = new Scanner(scanner.nextLine());
                while (tempScanner.hasNext()) {
                    String word = tempScanner.next();
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }

            for (Map.Entry<String, Integer> kvp : wordCount.entrySet()) {
                writer.println(kvp.getKey() + " - " + kvp.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
