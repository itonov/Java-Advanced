import java.util.*;

public class WeakStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        HashMap<String, String> studentsGrades = new LinkedHashMap<>();

        while (!"END".equals(inputLine)) {
            String[] inputParams = inputLine.split(" ");
            String name = inputParams[0] + " " + inputParams[1];
            String grades = "";
            for (int i = 2; i < inputParams.length; i++) {
                grades += inputParams[i];
            }
            studentsGrades.put(name, grades);
            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, String> kvp : studentsGrades.entrySet()) {
            String name = kvp.getKey();
            String grades = kvp.getValue();
            boolean first = false;
            boolean second = false;
            for (int i = 0; i < grades.length(); i++) {
                int currentGrade = Character.getNumericValue(grades.charAt(i));
                if (currentGrade == 2 || currentGrade == 3) {
                    if (!first) {
                        first = true;
                    } else {
                        second = true;
                        break;
                    }
                }
            }
            if (second) {
                System.out.println(name);
            }
        }
    }
}
