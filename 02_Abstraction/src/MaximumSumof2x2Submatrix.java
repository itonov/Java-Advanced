import java.util.Scanner;

public class MaximumSumof2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        int sum = 0;
        int[][] biggestMatrix = new int[2][2];

        for (int i = 0; i < matrix.length - 1; i++) {
            int[] firstLine = matrix[i];
            int[] secondLine = matrix[i + 1];

            for (int j = 0; j < firstLine.length - 1; j++) {
                int currentSum = firstLine[j] + firstLine[j + 1] + secondLine[j] + secondLine[j + 1];

                if (currentSum > sum) {
                    sum = currentSum;
                    biggestMatrix[0][0] = firstLine[j];
                    biggestMatrix[0][1] = firstLine[j + 1];
                    biggestMatrix[1][0] = secondLine[j];
                    biggestMatrix[1][1] = secondLine[j + 1];
                }
            }
        }

        for (int i = 0; i < biggestMatrix.length; i++) {
            for (int j = 0; j < biggestMatrix[i].length; j++) {
                System.out.print(biggestMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(sum);
    }
}
