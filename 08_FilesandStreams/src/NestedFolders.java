import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        String path = "C:\\Users\\Dell\\Desktop\\Files-and-Streams";
        File root = new File(path);
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            System.out.println(current.getName());
            count++;

            for (File file : current.listFiles()) {
                if (file.isDirectory()) {
                    dirs.offer(file);
                }
            }
        }
        System.out.println(count + " folders");
    }
}
