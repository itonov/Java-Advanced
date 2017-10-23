import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p01_BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = reader.readLine().split(", ");
        List<Integer> inputNumbers = new ArrayList<>();
        for (String number : inputLine) {
            inputNumbers.add(Integer.parseInt(number));
        }
        boolean isSnowing = true;
        while (isSnowing) {
            for (int i = inputNumbers.size() - 1; i >= 1; i--) {
                int firstNum = inputNumbers.get(i);
                int secondNum = inputNumbers.get(i - 1);

                inputNumbers.set(i, firstNum | secondNum);
                inputNumbers.set(i - 1, firstNum & secondNum);
            }

            boolean foundDif = false;
            for (int i = inputNumbers.size() - 1; i >= 0; i--) {
                int lastNum = inputNumbers.get(i);

                for (int j = i - 1; j >= 0; j--) {
                    int numToCheck = lastNum | inputNumbers.get(j);

                    if (numToCheck != lastNum) {
                        foundDif = true;
                        break;
                    }
                }
                if (foundDif) {
                    break;
                }
            }

            if (!foundDif) {
                isSnowing = false;
            }
        }

        System.out.println(inputNumbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
