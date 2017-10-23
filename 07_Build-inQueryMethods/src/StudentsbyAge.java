import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsbyAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> inputLines = new ArrayList<>();

        while (!"END".equals(input)) {
            inputLines.add(input);
            input = scanner.nextLine();
        }

        inputLines.stream()
                .filter(s -> 18 <= Integer.parseInt(s.split(" ")[2])
                && Integer.parseInt(s.split(" ")[2]) <= 24)
                .forEach(System.out::println);
    }
}
