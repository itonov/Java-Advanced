import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        HashMap<String, List<String>> teams = new HashMap<>();
        List<String> matches = new ArrayList<>();

        while (!"Season End".equals(inputLine)) {
            matches.add(inputLine);
            String[] inputParams = inputLine.split(" - ");
            String firstTeam = inputParams[0];
            String secondTeam = inputParams[1].split(" ")[0];
            teams.putIfAbsent(firstTeam, new ArrayList<>());
            teams.get(firstTeam).add(secondTeam);
            teams.putIfAbsent(secondTeam, new ArrayList<>());
            teams.get(secondTeam).add(firstTeam);
            inputLine = reader.readLine();
        }

        for (List<String> opponents : teams.values()) {
            Collections.sort(opponents);
        }

        String[] teamsOrder = reader.readLine().split(", ");
        for (String teamByOrder : teamsOrder) {
            for (Map.Entry<String, List<String>> kvp : teams.entrySet()) {
                String currentTeam = kvp.getKey();
                List<String> currentOpponents = kvp.getValue();
                List<String> printedMatches = new ArrayList<>();
                if (teamByOrder.equals(currentTeam)) {
                    for (String opponent : currentOpponents) {

                        for (String match : matches) {
                            String[] matchParams = match.split(" - ");
                            String firstTeam = matchParams[0];
                            String secondTeam = matchParams[1].split(" ")[0];
                            StringBuilder result = new StringBuilder(matchParams[1].split(" ")[2]);
                            if (currentTeam.equals(firstTeam) && opponent.equals(secondTeam)
                                    && !printedMatches.contains(match)) {
                                printMatch(firstTeam, secondTeam, result);
                                printedMatches.add(match);
                                break;
                            } else if (currentTeam.equals(secondTeam) && opponent.equals(firstTeam)
                                    && !printedMatches.contains(match)){
                                printMatch(secondTeam, firstTeam, result.reverse());
                                printedMatches.add(match);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printMatch(String firstTeam, String secondTeam, StringBuilder result) {
        System.out.println(firstTeam + " - " + secondTeam + " -> " + result);
    }
}
