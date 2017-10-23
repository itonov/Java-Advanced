import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        int linesCounter = 1;
        String lastAddedResource = "";
        while (!"stop".equals(inputLine)) {
            if (linesCounter % 2 == 0) {
                int quantity = Integer.parseInt(inputLine);
                resources.replace(lastAddedResource, resources.get(lastAddedResource),
                        resources.get(lastAddedResource) + quantity);
            } else {
                lastAddedResource = inputLine;
                if (!resources.containsKey(inputLine)) {
                    resources.put(lastAddedResource, 0);
                }
            }
            linesCounter++;
            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> kvp : resources.entrySet()) {
            System.out.println(kvp.getKey() + " -> " + kvp.getValue());
        }
    }
}
