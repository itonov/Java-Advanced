import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputCards = Arrays.asList(reader.readLine().split(" "));
        int totalValue = 0;
        for (int i = 0; i < inputCards.size(); i++) {
            String currentCard = inputCards.get(i);
            char currentLetter = takeCardLastLetter(currentCard);
            int repeats = 1;
            int currentValue = addCardValue(currentCard);
            for (int j = i + 1; j < inputCards.size(); j++) {
                String cardToCheck = inputCards.get(j);
                char letterToCheck = takeCardLastLetter(cardToCheck);
                if (letterToCheck == currentLetter) {
                    currentValue += addCardValue(cardToCheck);
                    repeats++;
                    if (j + 1 == inputCards.size()) {
                        i = j;
                    }
                } else {
                    i = j - 1;
                    break;
                }
            }
            totalValue += currentValue * repeats;
        }
        System.out.println(totalValue);
    }

    private static int addCardValue(String currentCard) {
        int currentValue = 0;
        if (currentCard.length() == 3) {
            currentValue = Integer.parseInt(currentCard.substring(0, 2));
        } else if (Character.isDigit(currentCard.charAt(0))) {
            currentValue = Character.getNumericValue(currentCard.charAt(0));
        } else {
            switch (currentCard.charAt(0)) {
                case 'J':
                    currentValue = 12;
                    break;
                case 'Q':
                    currentValue = 13;
                    break;
                case 'K':
                    currentValue = 14;
                    break;
                case 'A':
                    currentValue = 15;
                    break;
                default:
                    break;
            }
        }
        return currentValue;
    }

    private static char takeCardLastLetter(String currentCard) {
        char neededLetter = '\0';
        if (currentCard.length() == 3) {
            neededLetter = currentCard.charAt(2);
        } else {
            neededLetter = currentCard.charAt(1);
        }
        return neededLetter;
    }
}
