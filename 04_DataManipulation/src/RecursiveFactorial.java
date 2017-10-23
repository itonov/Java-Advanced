import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println(findFactorial(num));
    }

    private static int findFactorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * findFactorial(num - 1);
    }
}
