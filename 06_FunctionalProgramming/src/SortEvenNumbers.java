import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::valueOf).collect(Collectors.toList());
        numbers.removeIf(x -> x % 2 != 0);
        for (int i = 0; i < numbers.size(); i++) {
            if (i + 1 == numbers.size()) {
                System.out.print(numbers.get(i));
            } else {
                System.out.print(numbers.get(i) + ", ");
            }
        }
        System.out.println();
        numbers.sort((x, y) -> x.compareTo(y));
        for (int i = 0; i < numbers.size(); i++) {
            if (i + 1 == numbers.size()) {
                System.out.print(numbers.get(i));
            } else {
                System.out.print(numbers.get(i) + ", ");
            }
        }
    }
}
