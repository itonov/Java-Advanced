import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsNumber = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Double> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < studentsNumber; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::valueOf).toArray();
            double gradesSum = 0;
            for (double grade : grades) {
                gradesSum += grade;
            }
            double averageGrade = gradesSum / grades.length;

            studentsGrades.put(name, averageGrade);
        }

        for (Map.Entry<String, Double> kvp : studentsGrades.entrySet()) {
            System.out.println(kvp.getKey() + " is graduated with " + kvp.getValue());
        }
    }
}
