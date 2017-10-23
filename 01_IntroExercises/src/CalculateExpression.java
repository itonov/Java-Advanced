import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double sum = a + b + c;
        double firstExpressionPart = (Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2));
        double firstExpression = Math.pow(firstExpressionPart, (sum / Math.sqrt(c)));

        double secondExpression = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), (a - b));

        double difference = Math.abs((sum / 3) - ((firstExpression + secondExpression) / 2));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", firstExpression, secondExpression, difference);
    }
}
