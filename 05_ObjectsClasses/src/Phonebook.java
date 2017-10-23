import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, String> contacts = new LinkedHashMap<>();

        while (!"search".equals(input)) {
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];
            contacts.put(name, phoneNumber);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"stop".equals(input)) {
            if (contacts.containsKey(input)) {
                System.out.println(input + " -> " + contacts.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
            input = scanner.nextLine();
        }
    }
}
