import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindtheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();
        Function<int[], Integer> findSmallestNum = x -> Arrays.stream(x).reduce((z, y) -> z < y ? z : y).getAsInt();
        int neededIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == findSmallestNum.apply(numbers)) {
                neededIndex = i;
            }
        }
        System.out.println(neededIndex);
    }
}
