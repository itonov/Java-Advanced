import java.util.Scanner;

public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            result.append(String.format("\\u%04x", (int) inputText.charAt(i)));
        }

        System.out.println(result);
    }
}
