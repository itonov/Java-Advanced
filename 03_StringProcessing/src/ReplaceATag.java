import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        while (!"END".equals(input)) {
            sb.append(input);
            sb.append("\n");
            input = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("<a\\shref=\\s*\".*\">\\s*\\w*\\s*</a>");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String neededTag = matcher.group();
            String replacementTag = neededTag.replace("<a", "[URL").replaceFirst(">", "]")
                    .replace("</a>", "[/URL]");

            int startIndex = sb.indexOf(neededTag);
            int endIndex = startIndex + neededTag.length();
            sb = sb.replace(startIndex, endIndex, replacementTag);
        }

        System.out.println(sb);
    }
}
