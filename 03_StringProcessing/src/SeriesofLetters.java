import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeriesofLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputWord = scanner.nextLine();
        List<Character> letters = new ArrayList<>();
        char letterToCheck = '\0';

        for (int i = 0; i < inputWord.length(); i++) {
            letterToCheck = inputWord.charAt(i);
            if (letters.size() == 0) {
                letters.add(letterToCheck);
            } else if (letters.get(letters.size() - 1) != letterToCheck) {
                letters.add(letterToCheck);
            }
        }

        for (char letter : letters) {
            System.out.print(letter);
        }
    }
}
