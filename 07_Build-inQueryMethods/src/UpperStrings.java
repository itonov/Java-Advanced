import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UpperStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.asList(scanner.nextLine().split(" "));
        names.stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
    }
}
