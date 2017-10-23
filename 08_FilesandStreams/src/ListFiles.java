import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\Dell\\Desktop\\Files-and-Streams\\Files-and-Streams";
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File currentFile : files) {
                    if (!currentFile.isDirectory()) {
                        System.out.println(currentFile.getName() + ": " + currentFile.length());
                    }
                }
            }
        }
    }
}
