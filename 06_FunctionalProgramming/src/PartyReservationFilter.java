import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PartyReservationFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String inputCommands = scanner.nextLine();
        List<String> neededFilters = new ArrayList<>();
        while (!"Print".equals(inputCommands)) {
            String command = inputCommands.split(";")[0];
            switch (command) {
                case "Add filter":
                    neededFilters.add(inputCommands.substring(11, inputCommands.length()));
                    break;
                case "Remove filter":
                    String filterToRemove = inputCommands.substring(14, inputCommands.length());
                    neededFilters.remove(filterToRemove);
                    break;
                default:
            }
            inputCommands = scanner.nextLine();
        }

        for (String filter : neededFilters) {
            String parameter = filter.split(";")[0];
            String value = filter.split(";")[1];

            switch (parameter) {
                case "Starts with":
                    guests.removeIf(x -> x.startsWith(value));
                    break;
                case "Ends with":
                    guests.removeIf(x -> x.endsWith(value));
                    break;
                case "Length":
                    guests.removeIf(x -> x.length() == Integer.parseInt(value));
                    break;
                case "Contains":
                    guests.removeIf(x -> x.contains(value));
                    break;
                default:
                    break;
            }
        }
        System.out.println(String.join(" ", guests));
    }
}
