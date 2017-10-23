import java.util.Scanner;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        while (!inputName.equals("end")) {
            if (Pattern.matches(regex, inputName)) {
                System.out.println(inputName);
            }
            inputName = scanner.nextLine();
        }
    }
}
