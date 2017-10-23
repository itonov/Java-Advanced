import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        Function<String, Integer> parseNumber = x -> Integer.parseInt(x);
        int sum = 0;
        for (String number : input) {
            sum += parseNumber.apply(number);
        }
        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}
