import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateforNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int neededLength = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");
        Predicate<Integer> checkLength = x -> x <= neededLength;
        Arrays.stream(names).filter(s -> checkLength.test(s.length())).forEach(System.out::println);
    }
}
