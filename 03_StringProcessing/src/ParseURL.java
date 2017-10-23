import java.util.Scanner;

public class ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split("://");
        String protocol = "";
        String server = "";
        String resources = "";
        if (inputParams.length > 2) {
            System.out.println("Invalid URL");
        } else {
            protocol = inputParams[0];
            int serverEndIndex = inputParams[1].indexOf("/");
            server = inputParams[1].substring(0, serverEndIndex);
            resources = inputParams[1].substring(serverEndIndex + 1);
            System.out.println("Protocol = " + protocol);
            System.out.println("Server = " + server);
            System.out.println("Resources = " + resources);
        }
    }
}
