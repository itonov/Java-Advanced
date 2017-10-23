import java.util.Collections;
import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        printFigure(num);
    }

    private static void printFigure(int num) {
        if (num == 0) {
            return;
        }

        System.out.println(String.join("", Collections.nCopies(num, "*")));
        printFigure(num - 1);
        System.out.println(String.join("", Collections.nCopies(num, "#")));
    }
}
