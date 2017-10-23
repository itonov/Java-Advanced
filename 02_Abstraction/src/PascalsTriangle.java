import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] numbers = new long[n][n];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    numbers[i][0] = 1;
                } else {
                    numbers[i][j] = numbers[i - 1][j - 1] + numbers[i - 1][j];
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                long currentNum = numbers[i][j];

                if (currentNum != 0) {
                    System.out.print(currentNum + " ");
                }
            }
            System.out.println();
        }
    }
}
