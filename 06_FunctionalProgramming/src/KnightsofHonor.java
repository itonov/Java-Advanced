import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsofHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String> addTitleAndPrint = s -> System.out.println("Sir " + s);
        Arrays.stream(names).forEach(s -> addTitleAndPrint.accept(s));
    }
}
