import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyaPicture {
    public static void main(String[] args) {
        String input = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\picture.jpg";
        String output = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\picture-copy.jpg";

        try (FileInputStream fis = new FileInputStream(input);
             FileOutputStream fio = new FileOutputStream(output)){
            int oneByte = fis.read();
            while (oneByte >= 0) {
                fio.write(oneByte);
                oneByte = fis.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
