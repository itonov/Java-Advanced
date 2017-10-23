import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String firstNumHex = Integer.toHexString(a) + String.join("", Collections.nCopies((10 - Integer.toHexString(a).length()), " "));
        String firstNumBin = Integer.toBinaryString(a);

        int zeroesCount = (10 - firstNumBin.length());
        String zeroes = String.join("", Collections.nCopies(zeroesCount, "0"));

        DecimalFormat formatSecondNum = new DecimalFormat("#.00");

        int secondNumLength = formatSecondNum.format(b).length();
        String secondNumSpaces = String.join("", Collections.nCopies(10 - secondNumLength, " "));

        DecimalFormat formatThirdNum = new DecimalFormat("#.000");

        int thirdNumLength = formatThirdNum.format(c).length();
        String thirdNumSpaces = String.join("", Collections.nCopies(10 - thirdNumLength, " "));

        System.out.print("|" + firstNumHex.toUpperCase() + "|");
        System.out.print(zeroes + firstNumBin + "|");
        System.out.printf("%s%.2f|%.3f%s|",secondNumSpaces, b, c, thirdNumSpaces);
    }
}
