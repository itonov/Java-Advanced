import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameofBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(reader.readLine());
        if (number == 0) {
            System.out.println("0 -> 0");
            System.exit(1);
        } else if (number == 1) {
            System.out.println("0 -> 0");
            System.exit(1);
        }
        String command = reader.readLine();
        StringBuilder newNumber;
        while (!"Game Over!".equals(command)) {
            newNumber = new StringBuilder();
            switch (command) {
                case "Odd":
                    for (int i = 0; i < Long.toBinaryString(number).length(); i++) {
                        if ((i + 1) % 2 != 0) {
                            long bit = ((number >> i) & 1);
                            newNumber.append(bit);
                        }
                    }
                    newNumber.reverse();
                    number = Long.parseLong(newNumber.toString(), 2);
                    break;
                case "Even":
                    for (int i = 0; i < Long.toBinaryString(number).length(); i++) {
                        if ((i + 1) % 2 == 0) {
                            long bit = ((number >> i) & 1);
                            newNumber.append(bit);
                        }
                    }
                    newNumber.reverse();
                    number = Long.parseLong(newNumber.toString(), 2);
                    break;
                default:
                    break;
            }
            command = reader.readLine();
        }

        int bitCounter = 0;
        for (int i = 0; i < Long.toBinaryString(number).length(); i++) {
            long bit = ((number >> i) & 1);
            if (bit == 1) {
                bitCounter++;
            }
        }
        System.out.println(number + " -> " + bitCounter);
    }
}
