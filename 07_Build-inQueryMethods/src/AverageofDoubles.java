import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AverageofDoubles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("No match");
        } else {
            List<Double> numbers = Arrays.stream(input.split(" "))
                    .map(Double::valueOf)
                    .collect(Collectors.toList());

            OptionalDouble findAvg = numbers.stream().mapToDouble(Double::valueOf).average();

            if (findAvg.isPresent()) {
                System.out.printf("%.2f", findAvg.getAsDouble());
            }
        }
    }
}
