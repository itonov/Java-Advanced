import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputWords = scanner.nextLine().split(" ");
        List<String> uppercaseWords = new ArrayList<>();
        Predicate<String> wordCheck = x -> x.charAt(0) == x.toUpperCase().charAt(0);
        for (String word : inputWords) {
            if (wordCheck.test(word)) {
                uppercaseWords.add(word);
            }
        }
        System.out.println(uppercaseWords.size());
        for (String word : uppercaseWords) {
            System.out.println(word);
        }
    }
}
