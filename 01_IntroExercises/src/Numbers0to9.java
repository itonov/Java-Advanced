public class Numbers0to9 {
    public static void main(String[] args) {
        int number = 0;
        while (true) {
            if (number > 9) {
                break;
            }

            System.out.println("Number: " + number);

            number++;
        }
    }
}
