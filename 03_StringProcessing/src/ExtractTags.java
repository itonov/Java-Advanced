import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> tags = new ArrayList<>();
        Pattern pattern = Pattern.compile("<.*?>+");
        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                tags.add(matcher.group());
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join("\n", tags));
    }
}
