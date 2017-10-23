import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\input.txt";

        try (BufferedReader read = Files.newBufferedReader(Paths.get(path))){
            String currentLine = read.readLine();
            long sum = 0;
            while (currentLine != null) {
                for (char letter : currentLine.toCharArray()) {
                    sum += letter;
                }
                currentLine = read.readLine();
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
