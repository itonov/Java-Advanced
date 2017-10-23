import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Deque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String input = scanner.nextLine();
            switch (input.charAt(0)) {
                case '1':
                    String[] inputParams = input.split(" ");
                    numbers.push(Integer.parseInt(inputParams[1]));
                    break;
                case '2':
                    numbers.remove();
                    break;
                case '3':
                    int biggestNum = 0;
                    for (int num : numbers) {
                        if (num > biggestNum) {
                            biggestNum = num;
                        }
                    }
                    System.out.println(biggestNum);
                    break;
            }
        }
    }
}
