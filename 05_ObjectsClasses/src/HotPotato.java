import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> players = new ArrayDeque<>();
        players.addAll(Arrays.asList(input));

        while (players.size() > 1) {
            for (int i = 1; i < rotations; i++) {
                players.offer(players.poll());
            }
            System.out.println("Removed " + players.poll());
        }

        System.out.println("Last is " + players.poll());
    }
}
