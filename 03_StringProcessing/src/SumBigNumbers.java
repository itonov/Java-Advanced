import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNum = scanner.nextLine().replaceAll("^0+", "");
        String secondNum = scanner.nextLine().replaceAll("^0+", "");
        int lengthDiff = 0;
        StringBuilder zeroesToAdd = new StringBuilder();
        if (firstNum.length() < secondNum.length()) {
            lengthDiff = secondNum.length() - firstNum.length();
            for (int i = 0; i < lengthDiff; i++) {
                zeroesToAdd.append(0);
            }
            firstNum = zeroesToAdd + firstNum;
        } else {
            lengthDiff = firstNum.length() - secondNum.length();
            for (int i = 0; i < lengthDiff; i++) {
                zeroesToAdd.append(0);
            }
            secondNum = zeroesToAdd + secondNum;
        }

        int sum = 0;
        int numberInMind = 0;
        int remainder = 0;
        StringBuilder result = new StringBuilder();

        for (int i = firstNum.length() - 1; i >= 0; i--) {
            sum = Integer.parseInt(Character.toString(firstNum.charAt(i))) +
                    Integer.parseInt(Character.toString(secondNum.charAt(i))) + numberInMind;
            numberInMind = sum / 10;
            remainder = sum % 10;
            result.append(remainder);
            if (i == 0 && numberInMind != 0) {
                result.append(numberInMind);
            }
        }

        System.out.println(result.reverse());
    }
}
