import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HighScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Long> playersScores = new LinkedHashMap<>();
        List<String> allDuels = new ArrayList<>();
        String inputLine = reader.readLine();

        while (!"osu!".equals(inputLine)) {
            allDuels.add(inputLine);
            String[] duelParams = inputLine.split("<->");
            int firstPlayerScore = Integer.parseInt(duelParams[0].split(" ")[0]);
            String firstPlayerName = duelParams[0].split(" ")[1];
            int secondPlayerScore = Integer.parseInt(duelParams[1].split(" ")[1]);
            String secondPlayerName = duelParams[1].split(" ")[0];

            int scoreDiff = Math.abs(firstPlayerScore - secondPlayerScore);
            if (firstPlayerScore > secondPlayerScore) {
                addOrRemovePoints(playersScores, firstPlayerName, scoreDiff);
                addOrRemovePoints(playersScores, secondPlayerName, -scoreDiff);
            } else {
                addOrRemovePoints(playersScores, firstPlayerName, -scoreDiff);
                addOrRemovePoints(playersScores, secondPlayerName, scoreDiff);
            }
            inputLine = reader.readLine();
        }
        playersScores = playersScores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        for (Map.Entry<String, Long> kvp : playersScores.entrySet()) {
            String currentPlayer = kvp.getKey();
            Long totalScore = kvp.getValue();
            System.out.println(currentPlayer + " - (" + totalScore + ")");
            StringBuilder allDuelsToPrint = new StringBuilder();
            for (String duel : allDuels) {
                String[] currentDuelParams = duel.split("<->");
                int firstScore = Integer.parseInt(currentDuelParams[0].split(" ")[0]);
                int secondScore = Integer.parseInt(currentDuelParams[1].split(" ")[1]);
                String firstPlayer = currentDuelParams[0].split(" ")[1];
                String secondPlayer = currentDuelParams[1].split(" ")[0];
                int finalDuelScore;
                if (currentPlayer.equals(firstPlayer)) {
                    finalDuelScore = firstScore - secondScore;
                    addDuel(secondPlayer, finalDuelScore, allDuelsToPrint);
                } else if (currentPlayer.equals(secondPlayer)){
                    finalDuelScore = secondScore - firstScore;
                    addDuel(firstPlayer, finalDuelScore, allDuelsToPrint);
                }
            }
            System.out.print(allDuelsToPrint.toString());
        }
    }

    private static void addDuel(String playerName, int finalDuelScore, StringBuilder allDuels) {
        allDuels.append("*   ");
        allDuels.append(playerName);
        allDuels.append(" <-> ");
        allDuels.append(String.valueOf(finalDuelScore));
        allDuels.append("\n");
    }

    private static void addOrRemovePoints(HashMap<String, Long> playersScores, String playerName, int score) {
        if (!playersScores.containsKey(playerName)) {
            playersScores.put(playerName, 0L);
        }
        playersScores.put(playerName, playersScores.get(playerName) + score);
    }
}
