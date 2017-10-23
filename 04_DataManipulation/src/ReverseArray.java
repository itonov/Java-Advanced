import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[] reversedNums = reverseArray(nums, 0);

        for (int num : reversedNums) {
            System.out.print(num + " ");
        }
    }

    private static int[] reverseArray(int[] nums, int startIndex) {
        if (startIndex == nums.length / 2) {
            return nums;
        }

        int temp = nums[startIndex];
        nums[startIndex] = nums[nums.length - startIndex - 1];
        nums[nums.length - startIndex - 1] = temp;
        return reverseArray(nums, startIndex + 1);
    }
}
