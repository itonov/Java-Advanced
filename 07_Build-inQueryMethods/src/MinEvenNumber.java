import java.util.*;
import java.util.stream.Collectors;

public class MinEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        if (inputLine.isEmpty()) {
            System.out.println("No match");
        } else {
            List<Double> numbers = Arrays.stream(inputLine.split(" "))
                    .map(Double::valueOf)
                    .collect(Collectors.toList());

            numbers = numbers.stream()
                    .filter(s -> !s.isNaN())
                    .filter(s -> s % 2 == 0)
                    .collect(Collectors.toList());
            Optional<Double> check = numbers.stream().min((x, y) -> Double.compare(x, y));

            if (check.isPresent()){
                System.out.printf("%.2f", check.get());
            } else {
                System.out.println("No match");
            }

        }
    }
}
