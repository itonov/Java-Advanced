import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensorOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.nextLine();
        String type = scanner.nextLine();
        Predicate<Integer> checkNumber = x -> x % 2 == 0;
        for (int i = start; i <= end; i++) {
            switch (type) {
                case "odd":
                    if (!checkNumber.test(i)) {
                        System.out.print(i + " ");
                    }
                    break;
                case "even":
                    if (checkNumber.test(i)) {
                        System.out.print(i + " ");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
