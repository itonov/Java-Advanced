import java.util.*;

public class OverlappingIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intervalsNumber = Integer.parseInt(scanner.nextLine());
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < intervalsNumber; i++) {
            intervals.add(Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::valueOf).toArray());
        }

        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < intervals.size(); j++) {
                if (intervals.get(i)[0] < intervals.get(j)[0]) {
                    int temp = intervals.get(i)[0];
                    intervals.get(i)[0] = intervals.get(j)[0];
                    intervals.get(j)[0] = temp;
                    temp = intervals.get(i)[1];
                    intervals.get(i)[1] = intervals.get(j)[1];
                    intervals.get(j)[1] = temp;
                }
            }
        }
        System.out.println(checkForOverlap(intervals, 0));
    }

    private static boolean checkForOverlap(List<int[]> intervals, int startIndex) {
        if (startIndex + 1 == intervals.size()) {
            return false;
        } else if (intervals.get(startIndex)[0] + 1 == intervals.get(startIndex + 1)[0]
                && intervals.get(startIndex)[1] + 1 == intervals.get(startIndex + 1)[1]) {
            return true;
        } else {
            return checkForOverlap(intervals, startIndex + 1);
        }
    }
}
