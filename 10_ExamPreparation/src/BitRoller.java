import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitRoller {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int frozenIndex = Integer.parseInt(reader.readLine());
        int times = Integer.parseInt(reader.readLine());
        for (int i = 0; i < times; i++) {
            int firstBitValue = number & 1;

            int frozenBitValue = (number >> frozenIndex) & 1;
            int skipBitIndex = frozenIndex != 18 ? frozenIndex + 1 : 0;
            int skipBitValue = (number >> skipBitIndex) & 1;

            number >>= 1;

            if (frozenIndex != 0) {
                number |= firstBitValue << 18;
                number &= ~(3 << frozenIndex - 1);
                number |= frozenBitValue << frozenIndex;
                number |= skipBitValue << frozenIndex - 1;
            } else {
                number &= ~(1);
                number &= ~(1 << 18);

                number |= frozenBitValue;
                number |= skipBitValue << 18;
            }
        }
        System.out.println(number);
    }
}
