import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String firstInput = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\input.txt";
        String secondInput = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\input2.txt";
        String output = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\output.txt";

        try (BufferedReader firstReader = Files.newBufferedReader(Paths.get(firstInput));
             BufferedReader secondReader = Files.newBufferedReader(Paths.get(secondInput));
             PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            String firstLine = firstReader.readLine();
            while (firstLine != null) {
                writer.println(firstLine);
                firstLine = firstReader.readLine();
            }

            String secondLine = secondReader.readLine();
            while (secondLine != null) {
                writer.println(secondLine);
                secondLine = secondReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
