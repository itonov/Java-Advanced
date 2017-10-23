import java.math.BigInteger;
import java.util.Scanner;

public class BitFlipper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger inputNum = new BigInteger(scanner.nextLine());
        BigInteger seven = new BigInteger("7");
        BigInteger zero = new BigInteger("0");

        for (int i = 0; i <= 61; i++) {
            BigInteger current = inputNum.shiftRight(61 - i).and(seven);
            if (current.equals(seven) || current.equals(zero)) {
                inputNum = inputNum.xor(seven.shiftLeft(61 - i));
                i += 2;
            }
        }
        System.out.println(inputNum);
    }
}
