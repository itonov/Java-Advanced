import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        selectionSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, min, i);
        }
    }

    private static void bubbleSort(int[] nums) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void swap(int[] nums, int min, int index) {
        int temp = nums[min];
        nums[min] = nums[index];
        nums[index] = temp;
    }


}
