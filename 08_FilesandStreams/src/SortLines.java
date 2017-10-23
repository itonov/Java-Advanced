import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\input.txt";
        String outputPath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\output.txt";

        Path input = Paths.get(inputPath);
        Path output = Paths.get(outputPath);
        try {
            List<String> allLines = Files.readAllLines(input);
            Collections.sort(allLines);
            Files.write(output, allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
