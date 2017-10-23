import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashSet<String> parkedCars = new HashSet<>();
        while (!"END".equals(input)) {
            String[] commands = input.split(", ");
            String action = commands[0];
            String carNumber = commands[1];
            switch (action) {
                case "IN":
                    parkedCars.add(carNumber);
                    break;
                case "OUT":
                    parkedCars.remove(carNumber);
                    break;
            }
            input = scanner.nextLine();
        }
        if (parkedCars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join("\n", parkedCars));
        }
    }
}
