import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputUsername = scanner.nextLine();

        while (!inputUsername.equals("END")) {
            if (inputUsername.length() < 3 || inputUsername.length() > 16 || checkForIllegalChars(inputUsername)) {
                System.out.println("invalid");
            } else {
                System.out.println("valid");
            }

            inputUsername = scanner.nextLine();
        }
    }

    private static boolean checkForIllegalChars(String inputUsername) {
        Pattern pattern = Pattern.compile("[~#@*+%{}<>\\\\[\\\\]|\\\"^!]");
        Matcher matcher = pattern.matcher(inputUsername);

        return matcher.find();
    }
}