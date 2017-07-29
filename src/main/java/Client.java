import java.io.*;
import java.net.Socket;

/**
 * Created by vika on 03.05.17.
 */
public class Client implements Runnable {

    String  host;
    int port;
    CallBack callBack;

    Client (String host, int port, CallBack callBack){
        this.host = host;
        this.port = port;
        this.callBack = callBack;
    }

    void getConnect(){
                                Socket clientSocket = null;
                                try {
                                    clientSocket = new Socket("localhost", 4444);
                                    //получаем OutputStream
                                    OutputStream outputStream = clientSocket.getOutputStream();
                                    PrintWriter out = new PrintWriter(outputStream, true);
                                    out.println("Kiss my shiny metal ass!");
                                    out.flush();

                                    //читаем ответ
                                    InputStream inputStream = clientSocket.getInputStream();
                                    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                                    String answer = in.readLine();
                                    System.out.println(answer);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                                                                                                                              }

    void disconnect(){}

    void sendMassage(){}



    public void run() {
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("localhost", 4444);
            //получаем OutputStream
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println("Kiss my shiny metal ass!");
            out.flush();

            //читаем ответ
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String answer = in.readLine();
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
