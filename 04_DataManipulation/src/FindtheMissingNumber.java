import java.util.Arrays;
import java.util.Scanner;

public class FindtheMissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(numbers);
        System.out.println(findMissingNumber(numbers, 0));
    }

    private static int findMissingNumber(int[] numbers, int startIndex) {
        if (numbers[startIndex] + 1 == numbers[startIndex + 1]) {
            return findMissingNumber(numbers, startIndex + 1);
        } else {
            return numbers[startIndex] + 1;
        }
    }
}
