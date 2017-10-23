import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Function<int[], Integer> findMinNum = x -> Arrays.stream(x).reduce((z, y) -> z < y ? z : y).getAsInt();
        System.out.println(findMinNum.apply(numbers));
    }
}
