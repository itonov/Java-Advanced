import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ReverseandExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int divisor = Integer.parseInt(scanner.nextLine());
        reverseArray(numbers);
        Predicate<Integer> checkIfNumberIsDivisable = s -> s % divisor != 0;
        for (int num : numbers) {
            if (checkIfNumberIsDivisable.test(num)) {
                System.out.print(num + " ");
            }
        }
    }

    private static void reverseArray(int[] numbers) {
        int temp;

        for (int i = 0; i < numbers.length / 2; i++) {
            temp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = temp;
        }
    }
}
