import java.util.Arrays;
import java.util.Scanner;

public class NestedLoopsToRecursion {
    private static int numberOfLoops;
    private static int[] nums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numberOfLoops = Integer.parseInt(scanner.nextLine());
        nums = new int[numberOfLoops];
        iterateAndPrint(0);
    }

    private static void iterateAndPrint(int current) {
        if (current == numberOfLoops) {
            printArray();
            return;
        }

        for (int i = 1; i <= numberOfLoops ; i++) {
            nums[current] = i;
            iterateAndPrint(current + 1);
        }
    }

    private static void printArray() {
        System.out.println(Arrays.toString(nums).replaceAll("[\\[\\],]", ""));
    }
}
