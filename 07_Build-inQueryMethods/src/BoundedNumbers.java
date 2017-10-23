import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BoundedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLowerBound = scanner.nextInt();
        int inputUpperBound = scanner.nextInt();

        if (inputLowerBound > inputUpperBound) {
            int temp = inputLowerBound;
            inputLowerBound = inputUpperBound;
            inputUpperBound = temp;
        }

        int lowerBound = inputLowerBound;
        int upperBound = inputUpperBound;

        scanner.nextLine();
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        numbers.stream().filter(s -> lowerBound <= s && s <= upperBound).forEach(s -> System.out.print(s + " "));
    }
}
