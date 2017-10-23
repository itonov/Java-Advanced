import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MapDistricts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tokens = Arrays.asList(scanner.nextLine().split(" "));
        int bound = Integer.parseInt(scanner.nextLine());
        HashMap<String, List<Integer>> cities = new HashMap<>();

        for (String token : tokens) {
            String city = token.split(":")[0];
            int population = Integer.parseInt(token.split(":")[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(population);
        }

        cities.entrySet().stream()
                .filter(getFilterByPopulationPredicate(bound))
                .sorted(getSortByDescendingPopulationComparator())
                .forEach(getPrintMapEntryConsumer());
    }

    private static Consumer<? super Map.Entry<String, List<Integer>>> getPrintMapEntryConsumer() {
        return kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream()
                    .sorted((s1, s2) -> s2.compareTo(s1))
                    .limit(5)
                    .forEach(dp -> System.out.print(dp + " "));
            System.out.println();
        };
    }

    private static Comparator<? super Map.Entry<String, List<Integer>>> getSortByDescendingPopulationComparator() {
        return (kv1, kv2) ->
                Integer.compare(
                        kv2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        kv1.getValue().stream().mapToInt(Integer::valueOf).sum());
    }

    private static Predicate<? super Map.Entry<String, List<Integer>>> getFilterByPopulationPredicate(int bound) {
        return kv -> kv.getValue().stream()
                .mapToInt(Integer::valueOf)
                .sum() >= bound;
    }
}
