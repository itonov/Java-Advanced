import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbersNtoM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        int numToMultiply = firstNum + 1;

        BigInteger result = BigInteger.valueOf(0);

        do {
            if (numToMultiply == firstNum + 1) {
                result = result.add(BigInteger.valueOf(firstNum).multiply(BigInteger.valueOf(numToMultiply)));
            } else {
                result = result.multiply(BigInteger.valueOf(numToMultiply));
            }

            numToMultiply++;
        } while (numToMultiply <= secondNum);

        System.out.printf("product[%d..%d] = %d", firstNum, secondNum, result);
    }
}
