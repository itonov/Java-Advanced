import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Chocolates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int packetsCount = Integer.parseInt(scanner.nextLine());
        List<Integer> packets = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        Collections.sort(packets);
        List<Integer> result = findChocolates(packets, studentsCount);
        System.out.println("Min Difference is " + (Math.abs(result.get(0) - result.get(result.size() - 1))) + ".");
    }

    private static List<Integer> findChocolates(List<Integer> packets, int studentsCount) {
        if (packets.size() == studentsCount) {
            return packets;
        }
        int maxDifference = 0;
        int maxDiffIndex = 0;
        for (int i = 0; i < packets.size() - 2; i++) {
            for (int j = 0; j < packets.size(); j++) {
                int currentDiff = Math.abs(packets.get(i) - packets.get(j));
                if (currentDiff > maxDifference) {
                    maxDifference = currentDiff;
                    if (currentDiff > Math.abs(packets.get(i + 1) - packets.get(j))
                            && Math.abs(packets.get(i) - packets.get(i + 1)) > Math.abs(packets.get(i + 1) - packets.get(i + 2))) {
                        maxDiffIndex = i;
                    } else {
                        maxDiffIndex = j;
                    }
                }
            }
        }
        packets.remove(maxDiffIndex);
        return findChocolates(packets, studentsCount);
    }
}
