import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WritetoaFile {
    public static void main(String[] args) {
        String readPath = "C:\\Users\\Dell\\Desktop\\input.txt";
        String writePath = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\output.txt";
        List<Character> symbolsToEscape = new ArrayList<>(Arrays.asList(',', '.', '!', '?'));
        try (FileInputStream fileStream = new FileInputStream(readPath)){
            FileOutputStream out = new FileOutputStream(writePath);
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                if (!symbolsToEscape.contains((char)oneByte)) {
                    out.write(oneByte);
                }
                oneByte = fileStream.read();
            }
            out.close();
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
