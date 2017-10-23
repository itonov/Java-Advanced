import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequenceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = line[j];
            }
        }

        int mostRepeatsDiagonal = 0;
        String mostRepeatedWordDiagonal = "";

        int mostRepeatsCol = 0;
        String mostRepeatedWordCol = "";

        for (int i = 0; i < matrix.length; i++) {
            int tempRepeats = 0;
            String tempWord = "";
            int currentCol = 0;
            int currentRow = 0;
            for (int j = 0; j < matrix.length - 1; j++) {
                if (currentRow + 1 < matrix.length && currentCol + 1 < matrix[0].length) {
                    if (matrix[currentRow][currentCol].equals(matrix[currentRow + 1][currentCol + 1])) {
                        tempRepeats++;
                        tempWord = matrix[currentRow][currentCol];
                    }
                }
                currentCol++;
                currentRow++;
            }

            if (tempRepeats >= mostRepeatsDiagonal) {
                mostRepeatsDiagonal = tempRepeats;
                mostRepeatedWordDiagonal = tempWord;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            int tempRepeats = 0;
            String tempWord = "";
            int startCol = 0;
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i][startCol].equals(matrix[i + 1][startCol])) {
                    tempRepeats++;
                    tempWord = matrix[i][startCol];
                }

                if (i + 1 == matrix.length - 1 && startCol < matrix[0].length - 1) {
                    i = - 1;
                    startCol++;
                }
            }

            if (mostRepeatsCol < tempRepeats) {
                mostRepeatsCol = tempRepeats;
                mostRepeatedWordCol = tempWord;
            }
        }

        List<String> result = new ArrayList<>();

        if (mostRepeatsCol > mostRepeatsDiagonal) {
            for (int i = 0; i < mostRepeatsCol; i++) {
                result.add(mostRepeatedWordCol);
            }
        } else {
            for (int i = 0; i < mostRepeatsDiagonal + 1; i++) {
                result.add(mostRepeatedWordDiagonal);
            }
        }

        System.out.println(String.join(", ", result));
    }
}
