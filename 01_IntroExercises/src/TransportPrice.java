import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilometers = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double result = 0.00;

        if (kilometers < 20) {
            result += 0.70;

            switch (timeOfDay) {
                case "day":
                    result += kilometers * 0.79;
                    break;
                case "night":
                    result += kilometers * 0.90;
                    break;
            }
        } else if (kilometers < 100) {
            result = kilometers * 0.09;
        } else if (kilometers >= 100) {
            result = kilometers * 0.06;
        }

        System.out.printf("%.2f", result);
    }
}
