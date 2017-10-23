import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while (!"Party!".equals(commands)) {
            String action = commands.split(" ")[0];
            String param = commands.split(" ")[1];
            String criteria = commands.split(" ")[2];
            List<String> neededNames = new ArrayList<>();
            switch (action) {
                case "Remove":
                    switch (param) {
                        case "StartsWith":
                            guests.removeIf(x -> x.startsWith(criteria));
                            break;
                        case "EndsWith":
                            guests.removeIf(x -> x.endsWith(criteria));
                            break;
                        case "Length":
                            guests.removeIf(x -> x.length() == Integer.parseInt(criteria));
                            break;
                        default:
                            break;
                    }
                    break;
                case "Double":
                    switch (param) {
                        case "StartsWith":
                            neededNames = guests.stream()
                                    .filter(x -> x.startsWith(criteria))
                                    .collect(Collectors.toList());
                            for (int i = 0; i < guests.size(); i++) {
                                if (neededNames.contains(guests.get(i))) {
                                    guests.add(i + 1, guests.get(i));
                                    i++;
                                }
                            }
                            break;
                        case "EndsWith":
                            neededNames = guests.stream()
                                    .filter(x -> x.endsWith(criteria))
                                    .collect(Collectors.toList());
                            for (int i = 0; i < guests.size(); i++) {
                                if (neededNames.contains(guests.get(i))) {
                                    guests.add(i + 1, guests.get(i));
                                    i++;
                                }
                            }
                            break;
                        case "Length":
                            neededNames = guests.stream()
                                    .filter(x -> x.length() == Integer.parseInt(criteria))
                                    .collect(Collectors.toList());
                            for (int i = 0; i < guests.size(); i++) {
                                if (neededNames.contains(guests.get(i))) {
                                    guests.add(i + 1, guests.get(i));
                                    i++;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            commands = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }
}
