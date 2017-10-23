public class Transactions {
    public static void main(String[] args) throws InterruptedException {
        final int transactions = 100;
        final int operationsPerTransaction = 100;

        Account account = new Account();
        Runnable task = () -> {
            for (int i = 0; i < operationsPerTransaction; i++) {
                account.add(1);
                Thread.yield();
            }
        };
        Thread[] threads = new Thread[transactions];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(account.balance);
    }
}

class Account {
    int balance;

    synchronized void add(int amount){
        balance = balance + amount;
    }
}
