import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        scanner.nextLine();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        scanner.nextLine();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        int triangleArea = x1 * (y3 - y2) + x3 * (y2 - y1) + x2 * (y1 - y3);

        System.out.println(Math.abs(triangleArea / 2));
    }
}
