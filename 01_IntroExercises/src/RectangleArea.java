import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        double rectangleArea = a * b;

        System.out.printf("%.2f", rectangleArea);
    }
}
