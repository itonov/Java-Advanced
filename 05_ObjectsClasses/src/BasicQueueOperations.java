import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int elementsNumber = scanner.nextInt();
        int elementsToRemove = scanner.nextInt();
        int elementToCheck = scanner.nextInt();
        scanner.nextLine();
        Queue<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < elementsNumber; i++) {
            numbers.add(scanner.nextInt());
        }

        for (int i = 0; i < elementsToRemove; i++) {
            numbers.poll();
        }

        if (numbers.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            int smallestElement = Integer.MAX_VALUE;
            if (numbers.size() == 0) {
                smallestElement = 0;
            } else {
                for (int number : numbers) {
                    if (smallestElement > number) {
                        smallestElement = number;
                    }
                }
            }
            System.out.println(smallestElement);
        }

    }
}
