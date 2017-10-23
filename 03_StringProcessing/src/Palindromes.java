import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputWords = scanner.nextLine().split("\\W+");
        Set<String> palindromes = new TreeSet<>();

        for (String inputWord : inputWords) {
            if (inputWord.equals(new StringBuilder(inputWord).reverse().toString())) {
                palindromes.add(inputWord);
            }
        }

        System.out.println(palindromes);
    }
}
