import java.util.Scanner;

public class Program {

    static String  host = "localhost";
    static int port = 4444;
    static CallBack callBack;


    public static void main(String[] args) {
        String input;
        do {
            input = waitForCorrectlyInput();
        } while (!("s").equals(input));
        Server server = new Server();
        Thread thread2 = new Thread(server);
        thread2.start();

        do {
            input = waitForCorrectlyInput();
        } while (!("c").equals(input));
        Client client = new Client(host, port, callBack);
        Thread thread1 = new Thread(client);
        thread1.start();
    }

    private static String waitForCorrectlyInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
