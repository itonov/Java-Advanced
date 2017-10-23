import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int numToFind = Integer.parseInt(scanner.nextLine());
        System.out.println(binarySearch(nums, numToFind, 0, nums.length));
    }

    private static int binarySearch(int[] nums, int key, int lo, int hi) {
        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < nums[mid]) {
                return binarySearch(nums, key, lo, mid);
            } else if (key > nums[mid]) {
                return binarySearch(nums, key, mid, hi);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
