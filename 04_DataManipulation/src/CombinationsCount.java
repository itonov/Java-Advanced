import java.util.Scanner;

public class CombinationsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        System.out.println(combinationsCount(n, k));
    }

    private static int combinationsCount(int n, int k) {
        if ((n == k) || (k == 0)) {
            return 1;
        } else {
            return combinationsCount(n - 1, k) + combinationsCount(n - 1, k - 1);
        }
    }
}
