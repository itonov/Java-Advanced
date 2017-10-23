import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] matrixItems = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrixItems[j];
            }
        }

        while (true) {
            String[] inputParams = scanner.nextLine().split(" ");

            if (inputParams[0].equals("END")) {
                break;
            }

            if (inputParams.length < 5 || inputParams.length > 5 || !inputParams[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            int firstRow = Integer.parseInt(inputParams[1]);
            int firstCol = Integer.parseInt(inputParams[2]);
            int secondRow = Integer.parseInt(inputParams[3]);
            int secondCol = Integer.parseInt(inputParams[4]);
            boolean checkCoordinates = firstRow >= 0 && firstRow < matrix.length && firstCol >= 0
                    && firstCol < matrix[0].length && secondRow >= 0 && secondRow < matrix.length
                    && secondCol >= 0 && secondCol < matrix[0].length;

            if (checkCoordinates) {
                String temp = matrix[firstRow][firstCol];
                matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                matrix[secondRow][secondCol] = temp;

                for (String[] line : matrix) {
                    System.out.println(String.join(" ", line));
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
