import java.util.*;

public class HandsofCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<String, TreeSet<String>> playersDecks = new LinkedHashMap<>();

        while (!"JOKER".equals(inputLine)) {
            String playerName = inputLine.split(": ")[0];
            String[] cards = inputLine.split(": ")[1].split(", ");
            if (!playersDecks.containsKey(playerName)) {
                playersDecks.put(playerName, new TreeSet<>());
            }

            for (String card : cards) {
                playersDecks.get(playerName).add(card);
            }
            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, TreeSet<String>> kvp : playersDecks.entrySet()) {
            String player = kvp.getKey();
            TreeSet<String> cards = kvp.getValue();
            int totalValue = 0;

            for (String card : cards) {
                String leftPart;
                String rightPart;
                if (card.length() == 3) {
                    leftPart = card.substring(0, 2);
                    rightPart = card.split("")[2];
                } else {
                    leftPart = card.split("")[0];
                    rightPart = card.split("")[1];
                }
                int currentCardValue = 0;
                if (!Character.isDigit(leftPart.charAt(0))) {
                    switch (leftPart) {
                        case "J":
                            currentCardValue += 11;
                            break;
                        case "Q":
                            currentCardValue += 12;
                            break;
                        case "K":
                            currentCardValue += 13;
                            break;
                        case "A":
                            currentCardValue += 14;
                            break;
                    }
                } else {
                    currentCardValue += Integer.parseInt(leftPart);
                }

                switch (rightPart) {
                    case "S":
                        currentCardValue *= 4;
                        break;
                    case "H":
                        currentCardValue *= 3;
                        break;
                    case "D":
                        currentCardValue *= 2;
                        break;
                    case "C":
                        currentCardValue *= 1;
                        break;
                }
                totalValue += currentCardValue;
            }
            System.out.println(player + ": " + totalValue);
        }
    }
}
