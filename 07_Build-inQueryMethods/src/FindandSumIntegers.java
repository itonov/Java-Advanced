import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;

public class FindandSumIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputLine = Arrays.asList(scanner.nextLine().split(" "));

        OptionalInt check = inputLine.stream()
                .filter(s -> s.matches("^-?\\d+$"))
                .mapToInt(Integer::valueOf).reduce((x, y) -> x + y);

        if (check.isPresent()) {
            System.out.println(check.getAsInt());
        } else {
            System.out.println("No match");
        }
    }
}
