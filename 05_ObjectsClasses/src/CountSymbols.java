import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        TreeMap<Character, Integer> symbolsCount = new TreeMap<>();
        char[] symbols = inputText.toCharArray();

        for (char symbol : symbols) {
            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1);
            } else {
                symbolsCount.replace(symbol, symbolsCount.get(symbol), symbolsCount.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> kvp : symbolsCount.entrySet()) {
            System.out.println(kvp.getKey() + ": " + kvp.getValue() + " time/s");
        }
    }
}
