import java.util.*;

public class ExcellentStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        HashMap<String, List<Integer>> studentsGrades = new LinkedHashMap<>();

        while (!"END".equals(inputLine)) {
            String[] inputParams = inputLine.split(" ");
            String name = inputParams[0] + " " + inputParams[1];
            List<Integer> grades = new ArrayList<>();
            for (int i = 2; i < inputParams.length; i++) {
                grades.add(Integer.parseInt(inputParams[i]));
            }
            studentsGrades.put(name, new ArrayList<>());
            studentsGrades.get(name).addAll(grades);
            inputLine = scanner.nextLine();
        }

        studentsGrades.entrySet()
                .stream()
                .filter(s -> s.getValue().contains(6))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
