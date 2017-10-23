import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        int[][] biggestMatrix = findBiggestMatrix(matrix);
        int sum = 0;

        for (int[] line : biggestMatrix) {
            for (int num : line) {
                sum += num;
            }
        }

        System.out.println("Sum = " + sum);

        for (int[] line : biggestMatrix) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] findBiggestMatrix(int[][] matrix) {
        int biggestSum = 0;
        int[][] biggestMatrix = new int[3][3];
        for (int i = 0; i < matrix.length - 2; i++) {

            for (int j = 0; j < matrix[i].length - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if (biggestSum < currentSum) {
                    biggestSum = currentSum;
                    biggestMatrix[0][0] = matrix[i][j];
                    biggestMatrix[0][1] = matrix[i][j + 1];
                    biggestMatrix[0][2] = matrix[i][j + 2];
                    biggestMatrix[1][0] = matrix[i + 1][j];
                    biggestMatrix[1][1] = matrix[i + 1][j + 1];
                    biggestMatrix[1][2] = matrix[i + 1][j + 2];
                    biggestMatrix[2][0] = matrix[i + 2][j];
                    biggestMatrix[2][1] = matrix[i + 2][j + 1];
                    biggestMatrix[2][2] = matrix[i + 2][j + 2];
                }
            }
        }
        return biggestMatrix;
    }
}
