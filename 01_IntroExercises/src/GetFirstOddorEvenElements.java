import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetFirstOddorEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNums = scanner.nextLine().split(" ");
        String[] commands = scanner.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String num : inputNums) {
            numbers.add(Integer.parseInt(num));
        }

        int numberOfElements = Integer.parseInt(commands[1]);
        String oddOrEven = commands[2];

        List<Integer> result = new ArrayList<>();

        switch (oddOrEven) {
            case "odd":
                for (int number : numbers) {
                    boolean foundOddNum = false;
                    int counter = 0;

                    if (number % 2 == 1) {
                        foundOddNum = true;

                        result.add(number);
                    }

                    if (foundOddNum) {
                        counter++;
                    }

                    if (counter == numberOfElements) {
                        break;
                    }
                }
                break;
            case "even":
                for (int number : numbers) {
                    boolean foundEvenNum = false;
                    int counter = 0;

                    if (number % 2 == 0) {
                        foundEvenNum = true;

                        result.add(number);
                    }

                    if (foundEvenNum) {
                        counter++;
                    }

                    if (counter == numberOfElements) {
                        break;
                    }
                }
                break;
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
