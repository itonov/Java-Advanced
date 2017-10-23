import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FilterStudentsbyPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        HashMap<String, String> studentsPhones = new LinkedHashMap<>();

        while (!"END".equals(inputLine)) {
            String name = inputLine.split(" ")[0];
            name += " " + inputLine.split(" ")[1];
            String phoneNumber = inputLine.split(" ")[2];
            studentsPhones.put(name, phoneNumber);
            inputLine = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("(02\\d+)|(\\+3592\\d+)");
        studentsPhones.entrySet()
                .stream()
                .filter(s -> s.getValue().matches("(02\\d+)|(\\+3592\\d+)"))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
