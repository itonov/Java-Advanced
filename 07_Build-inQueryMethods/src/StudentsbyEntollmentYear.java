import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StudentsbyEntollmentYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        HashMap<String, String> facultyNumGrades = new LinkedHashMap<>();

        while (!"END".equals(inputLine)) {
            String[] inputParams = inputLine.split(" ");
            String facultyNum = inputParams[0];
            String grades = "";
            for (int i = 1; i < inputParams.length; i++) {
                grades += inputParams[i] + " ";
            }
            facultyNumGrades.put(facultyNum, grades);
            inputLine = scanner.nextLine();
        }

        facultyNumGrades.entrySet()
                .stream()
                .filter(s -> s.getKey().matches("\\d+14|\\d+15"))
                .forEach(s -> System.out.println(s.getValue()));
    }
}
