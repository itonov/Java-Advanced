import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        ArrayDeque<List<Integer>> inputNums = new ArrayDeque<>();

        for (int i = 0; i < lines; i++) {
            List<Integer> current = new ArrayList<>();
            String[] input = reader.readLine().split(" ");
            for (String element : input) {
                current.add(Integer.parseInt(element));
            }
            inputNums.offer(current);
        }
        List<Integer> result = new ArrayList<>();
        while (inputNums.size() > 0) {
            List<Integer> currentLine = inputNums.pop();
            int wave = currentLine.get(0);

            for (int i = 1; i < currentLine.size(); i++) {
                if (wave < currentLine.get(i)) {
                    inputNums.addLast(currentLine.subList(i, currentLine.size()));
                    break;
                }
            }
            result.add(wave);
        }
        System.out.println(result.size());
        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}
