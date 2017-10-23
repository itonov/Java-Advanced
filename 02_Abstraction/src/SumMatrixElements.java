import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputSize = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(inputSize[0]);
        int cols = Integer.parseInt(inputSize[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] reminder = scanner.nextLine().split(", ");

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(reminder[j]);
            }
        }

        int sum = 0;

        for (int[] num : matrix) {
            for (int number : num) {
                sum += number;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
