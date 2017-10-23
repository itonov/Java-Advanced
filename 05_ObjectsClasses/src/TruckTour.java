import java.util.ArrayDeque;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPumps = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> allPumps = new ArrayDeque<>();

        for (int i = 0; i < numberOfPumps; i++) {
            allPumps.addLast(scanner.nextLine());
        }
        int counter = 0;
        while (true) {
            int fuel = 0;
            boolean found = true;
            for (String petrolPump : allPumps) {
                int currentFuel = Integer.valueOf(petrolPump.split(" ")[0]);
                int distance = Integer.valueOf(petrolPump.split(" ")[1]);
                fuel+=currentFuel;
                if (fuel < distance) {
                    found = false;
                    break;
                }
                fuel-=distance;
            }

            if (found) {
                System.out.println(counter);
                break;
            }
            allPumps.addLast(allPumps.pop());
            counter++;
        }
    }
}
