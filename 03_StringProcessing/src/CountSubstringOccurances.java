import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurances {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine().toLowerCase();
        String searchString = scanner.nextLine().toLowerCase();
        int occurances = checkForOccurances(inputText, searchString);

        System.out.println(occurances);
    }

    private static int checkForOccurances(String inputText, String searchString) {
        int counter = 0;
        Pattern pattern = Pattern.compile(searchString);
        Matcher matcher = pattern.matcher(inputText);
        boolean found = matcher.find();
        while (found) {
            counter++;
            found = matcher.find(matcher.start() + 1);
        }
        return counter;
    }
}
