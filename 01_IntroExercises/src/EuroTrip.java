import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = scanner.nextDouble();

        BigDecimal priceBGN = new BigDecimal(quantity * 1.20);
        BigDecimal exchangeRate = new BigDecimal(4210500000000.00);
        BigDecimal priceDM = priceBGN.multiply(exchangeRate);

        System.out.printf("%.2f marks", priceDM);
    }
}
