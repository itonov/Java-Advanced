import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputGuest = scanner.nextLine();
        TreeSet<String> guests = new TreeSet<>();

        while (!"PARTY".equals(inputGuest)) {
            guests.add(inputGuest);
            inputGuest = scanner.nextLine();
        }

        inputGuest = scanner.nextLine();

        while (!"END".equals(inputGuest)) {
            guests.remove(inputGuest);
            inputGuest = scanner.nextLine();
        }

        System.out.println(guests.size());
        System.out.println(String.join("\n", guests));
    }
}
