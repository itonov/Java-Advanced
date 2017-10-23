import java.util.Arrays;
import java.util.Scanner;

public class Searching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int numToFind = Integer.parseInt(scanner.nextLine());

        System.out.println(binarySearch(nums, numToFind));
    }

    private static int binarySearch(int[] nums, int numToFind) {
        int lo = 0;
        int hi = nums.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (numToFind < nums[mid]) {
                hi = mid - 1;
            } else if (numToFind > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
