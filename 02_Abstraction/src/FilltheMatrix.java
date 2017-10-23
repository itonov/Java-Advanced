import java.util.Scanner;

public class FilltheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(inputParams[0]);
        String fillType = inputParams[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        switch (fillType) {
            case "A":
                matrix = fillMatrixTypeA(matrix);
                break;
            case "B":
                matrix = fillMatrixTypeB(matrix);
                break;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixTypeB(int[][] matrix) {
        int numToFill = 1;
        int colIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][colIndex] = numToFill;
            numToFill++;

            if (i + 1 == matrix.length && colIndex + 1< matrix.length) {
                colIndex++;
                int startRow = i;

                for (int j = startRow; j >= 0; j--) {
                    matrix[j][colIndex] = numToFill;
                    numToFill++;
                }

                colIndex++;
                i = -1;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixTypeA(int[][] matrix) {
        int startNum = 1;
        for (int i = 0; i < matrix.length; i++) {
            int fillNum = startNum;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = fillNum;
                fillNum += 3;
            }
            startNum++;
        }
        return matrix;
    }
}
