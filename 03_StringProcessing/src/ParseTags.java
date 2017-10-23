import java.util.Scanner;

public class ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputWords = scanner.nextLine();

        while (true) {
            if (!inputWords.contains("<upcase>")) {
                break;
            }
            int startIndex = inputWords.indexOf("<");
            inputWords = inputWords.replaceFirst("<upcase>", "");
            int endIndex = inputWords.indexOf("<");
            inputWords = inputWords.replaceFirst("</upcase>", "");
            String wordsToUp = inputWords.substring(startIndex, endIndex);
            inputWords = inputWords.replace(wordsToUp, wordsToUp.toUpperCase());
        }
        System.out.println(inputWords);
    }
}
