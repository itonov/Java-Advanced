import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsbyGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> inputLines = new ArrayList<>();

        while (!"END".equals(input)) {
            inputLines.add(input);
            input = scanner.nextLine();
        }

        inputLines.stream()
                .filter(s -> "2".equals(Character.toString(s.charAt(s.length() - 1))))
                .sorted((o1, o2) -> o1.split(" ")[0].compareTo(o2.split(" ")[0]))
                .forEach(System.out::println);
    }
}
