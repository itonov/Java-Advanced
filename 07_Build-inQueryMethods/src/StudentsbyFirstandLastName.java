import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsbyFirstandLastName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        List<String> students = new ArrayList<>();

        while (!"END".equals(inputLine)) {
            students.add(inputLine);
            inputLine = scanner.nextLine();
        }

        students.stream()
                .filter(s -> s.split(" ")[0].compareTo(s.split(" ")[1]) < 0)
                .forEach(System.out::println);
    }
}
