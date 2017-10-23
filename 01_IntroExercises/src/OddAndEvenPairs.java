import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        if (input.length % 2 == 1) {
            System.out.println("invalid length");
        } else {
            int[] numbers = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }

            for (int i = 0; i < numbers.length; i *= 2) {
                int firstNum = numbers[i];
                int secondNum = numbers[i + 1];

                boolean evenCheck = (firstNum % 2 == 0) && (secondNum % 2 == 0);
                boolean oddCheck = (firstNum % 2 == 1) && (secondNum % 2 == 1);

                if (evenCheck) {
                    System.out.println(firstNum + ", " + secondNum + " -> both are even");
                } else if (oddCheck) {
                    System.out.println(firstNum + ", " + secondNum + " -> both are odd");
                } else {
                    System.out.println(firstNum + ", " + secondNum + " -> different");
                }

                if (i == 0) {
                    i++;
                }
            }
        }
    }
}
