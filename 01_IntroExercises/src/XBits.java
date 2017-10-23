import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> binaries = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            binaries.add(String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        }

        int counter = 0;

        for (int i = 0; i < binaries.size() - 2; i++) {
            for (int j = 0; j < binaries.get(i).length() - 2; j++) {
                String a = binaries.get(i).charAt(j) + "" + binaries.get(i).charAt(j + 1) + binaries.get(i).charAt(j + 2);
                String b = binaries.get(i + 1).charAt(j) + "" + binaries.get(i + 1).charAt(j + 1) + binaries.get(i + 1).charAt(j + 2);
                String c = binaries.get(i + 2).charAt(j) + "" + binaries.get(i + 2).charAt(j + 1) + binaries.get(i + 2).charAt(j + 2);
                if (a.equals("101") && b.equals("010") && c.equals("101")) {
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
