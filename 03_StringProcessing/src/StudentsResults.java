import java.util.Scanner;

public class StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split("( - )|(, )");
        double gradesSum = 0;
        for (int i = 1; i < inputParams.length; i++) {
            gradesSum += Double.parseDouble(inputParams[i]);
        }
        double averageResult = gradesSum / 3;

        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|",
                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                inputParams[0], Double.parseDouble(inputParams[1]), Double.parseDouble(inputParams[2]),
                Double.parseDouble(inputParams[3]), averageResult));
    }
}
