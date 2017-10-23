import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectTheCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            input.add(scanner.nextLine());
        }
        String commands = scanner.nextLine();

        int coins = 0;
        int walls = 0;
        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < commands.length(); i++) {
            boolean reachedWall = false;
            switch (commands.charAt(i)) {
                case '>':
                    if (startCol + 1 < input.get(startRow).length()) {
                        startCol++;
                    } else {
                        walls++;
                        reachedWall = true;
                    }
                    break;
                case '<':
                    if (startCol - 1 >= 0 && startCol - 1 < input.get(startRow).length()) {
                        startCol--;
                    } else {
                        walls++;
                        reachedWall = true;
                    }
                    break;
                case '^':
                    if (startRow - 1 >= 0 && startRow - 1 < input.size()) {
                        startRow--;
                    } else {
                        walls++;
                        reachedWall = true;
                    }
                    break;
                case 'V':
                    if (startRow + 1 < input.size() && startCol < input.get(startRow + 1).length()) {
                        startRow++;
                    } else {
                        walls++;
                        reachedWall = true;
                    }
                    break;
            }

            if (input.get(startRow).charAt(startCol) == '$' && !reachedWall) {
                coins++;
            }
        }
        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + walls);
    }
}
