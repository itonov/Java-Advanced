import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        Pattern pattern = Pattern.compile("(?<firstNum>\\d+)(?<text>[a-z\\s*\\W*A-Z]+)(?<lastNum>\\d+\\.?\\d*)");
        Matcher matcher = pattern.matcher(inputLine);
        int counter = 0;
        BigDecimal result = BigDecimal.valueOf(0);
        while (matcher.find()) {
            double firstNum = Double.parseDouble(matcher.group("firstNum"));
            String text = matcher.group("text");
            double lastNum = Double.parseDouble(matcher.group("lastNum"));
            if (counter == 0) {
                if (text.length() % 2 == 0){
                    result = result.add(BigDecimal.valueOf(firstNum + lastNum));
                } else {
                    result = result.add(BigDecimal.valueOf(firstNum - lastNum));
                }
            } else {
                if (text.length() % 2 == 0) {
                    result = result.add(BigDecimal.valueOf(lastNum));
                } else {
                    result = result.subtract(BigDecimal.valueOf(lastNum));
                }
            }
            counter++;
            inputLine = inputLine.replaceFirst("\\d+\\.?\\d*", "");
            matcher = pattern.matcher(inputLine);
        }
        DecimalFormat df = new DecimalFormat("##.#######");
        System.out.println(df.format(result));
    }
}
