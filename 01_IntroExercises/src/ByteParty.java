import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < inputLines; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbers.add(number);
        }

        String[] commands = scanner.nextLine().split(" ");

        while (!commands[0].equals("party")) {

            int action = Integer.parseInt(commands[0]);
            int position = Integer.parseInt(commands[1]);

            switch (action) {
                case -1:
                    int mask = 1 << position;
                    for (int i = 0; i < numbers.size(); i++) {
                        int changedNum = numbers.get(i) ^ mask;
                        numbers.set(i, changedNum);
                    }
                    break;
                case 0:
                    int secondMask = ~(1 << position);
                    for (int i = 0; i < numbers.size(); i++) {
                        int changedNum = numbers.get(i) & secondMask;
                        numbers.set(i, changedNum);
                    }
                    break;
                case 1:
                    int thirdMask = 1 << position;
                    for (int i = 0; i < numbers.size(); i++) {
                        int changedNum = numbers.get(i) | thirdMask;
                        numbers.set(i, changedNum);
                    }
                    break;
            }

            commands = scanner.nextLine().split(" ");
        }

        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
