import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vika on 03.05.17.
 */
public class Server implements Runnable {

    public void run() {
        ServerSocket serverSocket = null; //порт
        try {
            serverSocket = new ServerSocket(4444);
            //в цикле обрабатываем входящие соединения.
            while (true)
            {

                //метод accept ждет, пока кто-то не подключится.
                Socket socket = serverSocket.accept();

                //читаем сообщение
                InputStream inputStream = socket.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                String message = in.readLine();

                //придумываем ответ – просто разворачиваем строку задом наперед
                String reverseMessage = new StringBuilder(message).reverse().toString();

                //отправляем ответ
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream, true);
                out.println(reverseMessage);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
