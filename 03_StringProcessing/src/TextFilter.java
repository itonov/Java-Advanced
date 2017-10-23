import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            String textToReplace = new String(new char[bannedWords[i].length()]).replace('\0', '*');
            text = text.replaceAll(bannedWords[i], textToReplace);
        }

        System.out.println(text);
    }
}
