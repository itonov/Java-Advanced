import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        Pattern pattern = Pattern.compile("([_,])([a-zA-Z]+)([0-9])");
        HashMap<String, String> decodedStrings = new LinkedHashMap<>();
        while (!"Ascend".equals(inputLine)) {
            for (Map.Entry<String, String> kvp : decodedStrings.entrySet()) {
                inputLine = inputLine.replaceAll(kvp.getKey(), kvp.getValue());
            }
            Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                String textToReplace = matcher.group();
                StringBuilder replacement = new StringBuilder();
                String lettersToReplace = textToReplace.substring(1, textToReplace.length() - 1);
                int lastDigit = Character.getNumericValue(textToReplace.charAt(textToReplace.length() - 1));
                switch (textToReplace.charAt(0)) {
                    case ',':
                        for (char letter : lettersToReplace.toCharArray()) {
                            replacement.append((char) (letter + lastDigit));
                        }
                        break;
                    case '_':
                        for (char letter : lettersToReplace.toCharArray()) {
                            replacement.append((char) (letter - lastDigit));
                        }
                        break;
                    default:
                        break;
                }
                inputLine = inputLine.replace(textToReplace, replacement.toString());
                decodedStrings.put(textToReplace, replacement.toString());
            }
            System.out.println(inputLine);
            inputLine = reader.readLine();
        }
    }
}
