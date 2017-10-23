import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();

        if (firstName.isEmpty()) {
            firstName = "*****";
        }

        if (lastName.isEmpty()) {
            lastName = "*****";
        }

        System.out.println("Hello, " + firstName + " " + lastName + "!");
    }
}
