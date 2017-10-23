import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> players = new ArrayDeque<>();
        players.addAll(Arrays.asList(input));
        int cycleCounter = 1;
        while (players.size() > 1) {
            for (int i = 1; i < rotations; i++) {
                players.offer(players.poll());
            }

            if (isPrime(cycleCounter)) {
                System.out.println("Prime " + players.peek());
            } else {
                System.out.println("Removed " + players.poll());
            }
            cycleCounter++;
        }
        System.out.println("Last is " + players.poll());
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
