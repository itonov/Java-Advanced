import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();
        Pattern firstPattern = Pattern.compile("\\+359\\s2\\s([1-9]{3})\\s([1-9]{4})");
        Pattern secondPattern = Pattern.compile("\\+359-2-([1-9]{3})-([1-9]{4})$");
        while (!"end".equals(inputNumber)) {
            Matcher firstMatcher = firstPattern.matcher(inputNumber);
            Matcher secondMatcher = secondPattern.matcher(inputNumber);
            if (firstMatcher.find() || secondMatcher.find()) {
                System.out.println(inputNumber);
            }
            inputNumber = scanner.nextLine();
        }
    }
}
