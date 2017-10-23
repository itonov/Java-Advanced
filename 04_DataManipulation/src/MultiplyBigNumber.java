import java.util.Scanner;

public class MultiplyBigNumber {
    public static String reallyBigNumber;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        reallyBigNumber = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(findProduct(reallyBigNumber, num));
    }

    private static String findProduct(String bigNumber, int num) {
        if (num == 1) {
            return bigNumber;
        }
        int numberInMind = 0;
        int secondNum = 0;
        int secondIndex = reallyBigNumber.length() - 1;
        StringBuilder newBigNum = new StringBuilder();
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int firstNum = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            if (secondIndex >= 0){
                secondNum = Integer.parseInt(String.valueOf(reallyBigNumber.charAt(secondIndex)));
                secondIndex--;
            } else {
                secondNum = 0;
            }
            int currentSum = firstNum + secondNum + numberInMind;
            int numToAdd = currentSum % 10;
            numberInMind = currentSum / 10;
            newBigNum.append(numToAdd);
            if (i == 0 && numberInMind != 0) {
                newBigNum.append(numberInMind);
            }
        }
        newBigNum.reverse();
        return findProduct(newBigNum.toString(), num - 1);
    }
}
