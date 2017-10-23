import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String firstWord = input[0];
        String secondWord = input[1];
        int sum = 0;

        if (firstWord.length() > secondWord.length()) {
            for (int i = 0; i < secondWord.length(); i++) {
                sum += firstWord.charAt(i) * secondWord.charAt(i);
            }

            for (int i = secondWord.length(); i < firstWord.length(); i++) {
                sum += firstWord.charAt(i);
            }
        } else if (firstWord.length() < secondWord.length()) {
            for (int i = 0; i < firstWord.length(); i++) {
                sum += firstWord.charAt(i) * secondWord.charAt(i);
            }

            for (int i = firstWord.length(); i < secondWord.length(); i++) {
                sum += secondWord.charAt(i);
            }
        } else {
            for (int i = 0; i < firstWord.length(); i++) {
                sum += firstWord.charAt(i) * secondWord.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
