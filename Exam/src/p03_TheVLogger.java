import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class p03_TheVLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, TreeSet<String>> followersForEachVlogger = new LinkedHashMap<>();
        HashMap<String, Integer> followingCount = new LinkedHashMap<>();
        String input = reader.readLine();

        while (!"Statistics".equals(input)) {
            String[] inputParams = input.split(" ");
            String firstVlogger = inputParams[0];
            String action = inputParams[1];

            switch (action) {
                case "joined":
                    followersForEachVlogger.putIfAbsent(firstVlogger, new TreeSet<>());
                    followingCount.putIfAbsent(firstVlogger, 0);
                    break;
                case "followed":
                    String secondVlogger = inputParams[2];
                    if (!firstVlogger.equals(secondVlogger)) {
                        if (followersForEachVlogger.containsKey(firstVlogger)
                                && followersForEachVlogger.containsKey(secondVlogger)) {
                            if (!followersForEachVlogger.get(secondVlogger).contains(firstVlogger)) {
                                followersForEachVlogger.get(secondVlogger).add(firstVlogger);
                                followingCount.put(firstVlogger, followingCount.get(firstVlogger) + 1);
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
            input = reader.readLine();
        }

        System.out.println("The V-Logger has a total of " + followersForEachVlogger.keySet().size() + " vloggers in its logs.");
        followersForEachVlogger = followersForEachVlogger.entrySet()
                .stream()
                .sorted(Comparator.comparingInt((Map.Entry<String, TreeSet<String>> x) -> x.getValue().size()).reversed()
                        .thenComparingInt(x -> followingCount.get(x.getKey())))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a,b) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        int counter = 1;
        for (Map.Entry<String, TreeSet<String>> kvp : followersForEachVlogger.entrySet()) {
            String currentVlogger = kvp.getKey();
            TreeSet<String> currentFollowers = kvp.getValue();
            System.out.printf("%d. %s : %d followers, %d following%n", counter, currentVlogger, currentFollowers.size(),
                    followingCount.get(currentVlogger));
            if (counter == 1) {
                for (String follower : currentFollowers) {
                    System.out.printf("*  %s%n", follower);
                }
            }
            counter++;
        }
    }
}
