import java.util.*;

public class EncryptSortandPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        List<Integer> numbers = new ArrayList<>();

        String vowels = "AEIOUaeiou";

        for (int i = 0; i < words.length; i++) {
            int currentSum = 0;
            for (int j = 0; j < words[i].length(); j++) {
                String currentLetter = String.valueOf(words[i].charAt(j));

                if (vowels.contains(currentLetter)) {
                    currentSum += currentLetter.charAt(0) * words[i].length();
                } else {
                    currentSum += currentLetter.charAt(0) / words[i].length();
                }
            }

            numbers.add(currentSum);
        }

        Collections.sort(numbers);

        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
