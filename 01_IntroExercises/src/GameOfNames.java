import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playersCount = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> playersPoints = new LinkedHashMap<>();

        for (int i = 0; i < playersCount; i++) {
            String playerName = scanner.nextLine();
            int playerPoints = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < playerName.length(); j++) {
                int letterPoint = playerName.charAt(j);

                if (letterPoint % 2 == 0) {
                    playerPoints += letterPoint;
                } else {
                    playerPoints -= letterPoint;
                }
            }

            playersPoints.put(playerName, playerPoints);
        }

        String winnerName = "";
        int winnerPoints = 0;

        for (Map.Entry<String, Integer> kvp : playersPoints.entrySet()) {
            String playerName = kvp.getKey();
            int playerPoints = kvp.getValue();

            if (winnerPoints < playerPoints) {
                winnerName = playerName;
                winnerPoints = playerPoints;
            }
        }

        System.out.printf("The winner is %s - %d points", winnerName, winnerPoints);
    }
}
