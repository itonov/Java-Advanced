import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListofPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int end = Integer.parseInt(scanner.nextLine());
        int[] divisors = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int i = 1; i <= end; i++) {
            boolean matches = true;
            for (int divisor : divisors) {
                Predicate<Integer> checkNumber = x -> x % divisor == 0;
                if (!checkNumber.test(i)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                System.out.print(i + " ");
            }
        }
    }
}
