import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::valueOf).toArray();
        UnaryOperator<Double> addVat = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        for (double num : numbers) {
            System.out.println(String.format("%1$.2f", addVat.apply(num)).replaceAll("\\.", ","));
        }
    }
}
