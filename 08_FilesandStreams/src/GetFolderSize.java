import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\Dell\\Desktop\\Files-and-Streams";
        File file = new File(path);
        long sum = 0;

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    sum += f.length();
                }
            } else {
                sum += file.length();
            }
        }

        System.out.println(sum);
    }
}
