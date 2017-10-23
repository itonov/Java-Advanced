import java.util.*;

public class FilterbyAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Integer> nameAge = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.nextLine().split(", ");
            String name = inputParams[0];
            int age = Integer.parseInt(inputParams[1]);
            nameAge.put(name, age);
        }

        String condition = scanner.nextLine();
        int neededAge = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        List<String> remainingNames = new ArrayList<>();
        switch (condition) {
            case "older":
                nameAge.entrySet().stream()
                        .filter(s -> s.getValue() >= neededAge)
                        .forEach(s -> remainingNames.add(s.getKey()));
                checkFormatAndPrint(format, remainingNames, nameAge);
                break;
            case "younger":
                nameAge.entrySet().stream()
                        .filter(s -> s.getValue() < neededAge)
                        .forEach(s -> remainingNames.add(s.getKey()));
                checkFormatAndPrint(format, remainingNames, nameAge);
                break;
            default:
                break;
        }
    }

    private static void checkFormatAndPrint(String neededFormat, List<String> remainingNames, HashMap<String, Integer> nameAge) {
        switch (neededFormat) {
            case "name":
                nameAge.entrySet().stream()
                        .filter(s -> remainingNames.contains(s.getKey()))
                        .forEach(s -> System.out.println(s.getKey()));
                break;
            case "age":
                nameAge.entrySet().stream()
                        .filter(s -> remainingNames.contains(s.getKey()))
                        .forEach(s -> System.out.println(s.getValue()));
                break;
            case "name age":
                nameAge.entrySet().stream()
                        .filter(s -> remainingNames.contains(s.getKey()))
                        .forEach(s -> System.out.println(s.getKey() + " - " + s.getValue()));
                break;
        }
    }
}
