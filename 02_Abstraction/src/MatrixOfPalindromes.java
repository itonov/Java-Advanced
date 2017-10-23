import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String wordToFill = generateWord(i, j);
                matrix[i][j] = wordToFill;
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] line : matrix) {
            for (String word : line) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }

    private static String generateWord(int row, int col) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char firstLastLetter = alphabet.charAt(row);
        char middleLetter = alphabet.charAt(col + row);
        return String.valueOf(firstLastLetter) + String.valueOf(middleLetter) + String.valueOf(firstLastLetter);
    }
}
