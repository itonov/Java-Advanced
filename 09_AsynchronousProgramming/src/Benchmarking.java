import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Benchmarking {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int number = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            numbers.add(i);
        }
        long start = System.nanoTime();
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future[] results = new Future[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            Future<Boolean> future = es.submit(() -> isPrime(num));
            results[i] = future;
        }
        es.awaitTermination(100L, TimeUnit.MILLISECONDS);
        long total = System.nanoTime() - start;
        System.out.println("Execution time: " + total);
        es.shutdown();
        for (Future f : results) {
            System.out.println(f.get());
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
