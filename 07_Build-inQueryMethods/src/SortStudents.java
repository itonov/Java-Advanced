import java.util.*;

public class SortStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        List<String> students = new ArrayList<>();

        while (!"END".equals(inputLine)) {
            students.add(inputLine);
            inputLine = scanner.nextLine();
        }

        students.stream()
                .sorted(Comparator.comparing(s -> s.toString().split(" ")[1])
                        .thenComparing(s -> s.toString().split(" ")[0], Collections.reverseOrder()))
                .forEach(System.out::println);
    }
}
