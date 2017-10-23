import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\input.txt";
        String outputPath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\output.txt";
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        List<Character> punctuationMarks = new ArrayList<>(Arrays.asList('!', ',', '.', '?'));
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            int oneByte = reader.read();
            int vowelsCounter = 0;
            int punctuationCounter = 0;
            int consonantsCounter = 0;

            while (oneByte >= 0) {
                char currentChar = (char) oneByte;
                if (vowels.contains(currentChar)) {
                    vowelsCounter++;
                } else if (punctuationMarks.contains(currentChar)) {
                    punctuationCounter++;
                } else {
                    consonantsCounter++;
                }
                oneByte = reader.read();
            }

            writer.println("Vowels: " + vowelsCounter);
            writer.println("Consonants: " + consonantsCounter);
            writer.println("Punctuation: " + punctuationCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
