import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        int countToPop = scanner.nextInt();
        int numToCheck = scanner.nextInt();
        scanner.nextLine();
        Deque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < numberOfElements; i++) {
            numbers.push(scanner.nextInt());
        }

        for (int i = 0; i < countToPop; i++) {
            numbers.pop();
        }
        int smallestElement = Integer.MAX_VALUE;
        if (numbers.contains(numToCheck)) {
            System.out.println("true");
        } else {
            if (numbers.size() == 0) {
                smallestElement = 0;
            } else {
                for (int i = 0; i < numbers.size(); i++) {
                    if (smallestElement > numbers.peek()) {
                        smallestElement = numbers.pop();
                    }
                }
            }
            System.out.println(smallestElement);
        }
    }
}
