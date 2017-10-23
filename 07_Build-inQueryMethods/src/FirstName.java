import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.asList(scanner.nextLine().split(" "));
        List<String> letters = Arrays.asList(scanner.nextLine().toLowerCase().split(" "));
        Optional<String> checkName = names.stream()
                .filter(s -> letters.contains(Character.toString(s.charAt(0)).toLowerCase()))
                .sorted()
                .findFirst();

        if (checkName.isPresent()) {
            System.out.println(checkName.get());
        } else {
            System.out.println("No match");
        }
    }
}
