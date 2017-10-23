import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> text = new ArrayDeque<>();
        ArrayDeque<Integer> operations = new ArrayDeque<>();
        int countOfAddedElements = 0;
        StringBuilder removedElements = new StringBuilder();
        for (int i = 0; i < numberOfCommands; i++) {
            String inputLine = scanner.nextLine();
            switch (inputLine.charAt(0)) {
                case '1':
                    char[] textToAdd = inputLine.split(" ")[1].toCharArray();
                    for (int j = textToAdd.length - 1; j >= 0; j--) {
                        text.push(String.valueOf(textToAdd[j]));
                    }
                    countOfAddedElements = textToAdd.length;
                    operations.add(1);
                    break;
                case '2':
                    int elementsToRemove = Integer.parseInt(inputLine.split(" ")[1]);
                    for (int j = 0; j < elementsToRemove; j++) {
                        removedElements.append(text.pop());
                    }
                    operations.add(2);
                    break;
                case '3':
                    String wholeText = text.toString().replace("[", "").replace("]", "")
                            .replaceAll(", ", "");
                    int index = Integer.parseInt(inputLine.split(" ")[1]) - 1;
                    System.out.println(wholeText.charAt(index));
                    break;
                case '4':
                    int lastOperation = operations.pop();
                    if (lastOperation == 1) {
                        for (int j = 0; j < countOfAddedElements; j++) {
                            text.pop();
                        }
                        countOfAddedElements = 0;
                    } else if (lastOperation == 2) {
                        removedElements.reverse();
                        char[] lettersToAdd = removedElements.toString().toCharArray();
                        for (char letter : lettersToAdd) {
                            text.push(String.valueOf(letter));
                        }
                        removedElements = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
