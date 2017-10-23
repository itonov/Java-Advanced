import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStones = reader.readLine().split(" ");
        ArrayDeque<Integer> stones = new ArrayDeque<>();
        ArrayDeque<Integer> gold = new ArrayDeque<>();
        for (String stone : inputStones) {
            stones.addLast(Integer.parseInt(stone));
        }

        String commands = reader.readLine();
        while (!"Revision".equals(commands)) {
            String[] commandsList = commands.split(" ");
            String action = commandsList[0];
            int doses = Integer.parseInt(commandsList[2]);
            switch (action) {
                case "Apply":
                    for (int i = 0; i < doses; i++) {
                        if (stones.size() > 0) {
                            int currentStone = stones.pop() - 1;
                            if (currentStone == 0) {
                                gold.addLast(currentStone);
                            } else {
                                stones.addLast(currentStone);
                            }
                        }
                    }
                    break;
                case "Air":
                    if (gold.size() > 0) {
                        int goldToReturn = gold.pollLast() + doses;
                        stones.addLast(goldToReturn);
                    }
                    break;
                default:
                    break;
            }

            commands = reader.readLine();
        }

        System.out.println(stones.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(gold.size());
    }
}
