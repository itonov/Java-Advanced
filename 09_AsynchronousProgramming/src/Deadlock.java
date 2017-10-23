public class Deadlock {
    public static void main(String[] args) {
        MyClass first = new MyClass("First");
        MyClass second = new MyClass("Second");

        Thread tFirst = new Thread(() -> first.a(second));
        Thread tSecond = new Thread(() -> second.a(first));

        tFirst.start();
        tSecond.start();
    }
}

class MyClass {
    String id;

    public MyClass(String id) {
        this.id = id;
    }

    synchronized void a(MyClass other) {
        System.out.printf("%s called method A on %s%n", this.id, other.id);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        other.b(this);
    }

    synchronized void b(MyClass other) {
        System.out.printf("%s called method A on %s%n", other.id, this.id);
        other.c();
    }

    synchronized private void c() {
        System.out.println(this.id + " done");
    }
}