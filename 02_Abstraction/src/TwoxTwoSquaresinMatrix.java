import java.util.Scanner;

public class TwoxTwoSquaresinMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = inputLine[j].charAt(0);
            }
        }

        int count = calculateSquaresCount(matrix);

        System.out.println(count);
    }

    private static int calculateSquaresCount(char[][] matrix) {
        int result = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                char currentChar = matrix[i][j];

                if (currentChar == matrix[i][j + 1] && currentChar == matrix[i + 1][j]
                        && currentChar == matrix[i + 1][j + 1]) {
                    result++;
                }
            }
        }
        return result;
    }
}
