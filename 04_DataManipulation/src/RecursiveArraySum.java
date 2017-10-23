import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        System.out.println(findSum(nums, 0));
    }

    private static int findSum(int[] nums, int currentIndex) {
        if (currentIndex + 1 == nums.length) {
            return nums[currentIndex];
        }
        return nums[currentIndex] + findSum(nums, currentIndex + 1);
    }
}
