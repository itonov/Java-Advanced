import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            switch (command) {
                case "add":
                    UnaryOperator<Integer> add = x -> x + 1;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = add.apply(numbers[i]);
                    }
                    break;
                case "multiply":
                    UnaryOperator<Integer> multiply = x -> x * 2;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = multiply.apply(numbers[i]);

                    }
                    break;
                case "subtract":
                    UnaryOperator<Integer> subtract = x -> x - 1;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = subtract.apply(numbers[i]);

                    }
                    break;
                case "print":
                    Arrays.stream(numbers).forEach(s -> System.out.print(s + " "));
                    System.out.println();
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
