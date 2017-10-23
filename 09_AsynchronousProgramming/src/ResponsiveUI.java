import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResponsiveUI {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int number = Integer.parseInt(scanner.nextLine());
        Runnable task = () -> printPrimes(number);
        Thread thread = new Thread(task);
        thread.start();

        while (true) {
            String command = scanner.nextLine();

            if ("stop".equals(command)) {
                thread.interrupt();
                break;
            } else {
                System.out.println("unknown command");
            }
        }
        thread.join();
    }

    static void printPrimes(int number) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            if (isPrime(number)) {
                primes.add(number);
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted...");
                break;
            }
        }
        System.out.println(primes.stream()
                .limit(10)
                .collect(Collectors.toList()) + "...");
        System.out.printf("%s primes calculated.", primes.size());
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
