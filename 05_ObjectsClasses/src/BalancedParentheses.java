import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        ArrayDeque<String> elements = new ArrayDeque<>();
        elements.addAll(Arrays.asList(input));
        boolean balanced = true;
        while (true) {
            if (elements.size() % 2 != 0) {
                System.out.println("NO");
                break;
            }
            String firstElement = elements.pollFirst();
            String lastElement = elements.pollLast();
            switch (firstElement) {
                case "{":
                    if (!"}".equals(lastElement)) {
                        balanced = false;
                    }
                    break;
                case "[":
                    if (!"]".equals(lastElement)) {
                        balanced = false;
                    }
                    break;
                case "(":
                    if (!")".equals(lastElement)) {
                        balanced = false;
                    }
                    break;
            }
            if (!balanced) {
                System.out.println("NO");
                break;
            } else if (elements.size() == 0) {
                System.out.println("YES");
                break;
            }
        }
    }
}
