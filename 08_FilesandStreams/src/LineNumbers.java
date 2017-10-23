import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\input.txt";
        String outputPath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){
            String line = reader.readLine();
            int lineCounter = 1;
            while (line != null) {
                writer.println(lineCounter + ". " + line);
                lineCounter++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
