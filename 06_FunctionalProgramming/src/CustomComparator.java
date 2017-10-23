import java.util.Arrays;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] oddNums = Arrays.stream(numbers).filter(x -> x % 2 != 0).sorted().toArray();
        int[] evenNums = Arrays.stream(numbers).filter(x -> x % 2 == 0).sorted().toArray();
        for (int num : evenNums) {
            System.out.print(num + " ");
        }
        for (int num : oddNums) {
            System.out.print(num + " ");
        }
    }
}
