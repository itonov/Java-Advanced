import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textToCheck = reader.readLine();
        String input = reader.readLine();

        while (!"Print".equals(input)) {
            StringBuilder neededPattern = new StringBuilder();
            int slashIndex = 0;
            boolean backLash = false;
            char[] wordLetters = input.toCharArray();
            for (int i = 0, wordLettersLength = wordLetters.length; i < wordLettersLength; i++) {
                char letter = wordLetters[i];
                if (Character.toString(letter).equals("%")) {
                    neededPattern.append("\\S*");
                } else if (Character.toString(letter).equals("\\")) {
                    slashIndex = i;
                    backLash = true;
                } else if (Character.isLetterOrDigit(letter)) {
                    neededPattern.append(letter);
                } else {
                    neededPattern.append("\\").append(letter);
                }
            }

            Pattern pattern = Pattern.compile(neededPattern.toString());
            Matcher matcher = pattern.matcher(textToCheck);

            while (matcher.find()) {
                StringBuilder replacement = new StringBuilder(matcher.group());
                replacement.reverse();
                if (backLash) {
                    replacement.insert(slashIndex, "\\");
                    replacement.replace(slashIndex, slashIndex + 1, "");
                }
                textToCheck = textToCheck.replaceAll(pattern.toString(), replacement.toString());
            }
            input = reader.readLine();
        }
        System.out.println(textToCheck);
    }
}
