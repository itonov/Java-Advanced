import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterStudentsbyEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String neededEmail = "@gmail.com";
        String inputStudent = scanner.nextLine();
        List<String> studentsEmails = new ArrayList<>();

        while (!"END".equals(inputStudent)) {
            studentsEmails.add(inputStudent);
            inputStudent = scanner.nextLine();
        }

        studentsEmails.stream()
                .filter(s -> s.endsWith(neededEmail))
                .forEach(System.out::println);
    }
}
