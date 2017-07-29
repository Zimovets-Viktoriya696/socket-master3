import com.google.gson.Gson;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;

/**
 * Created by vika on 18.07.17.
 */
public class Link {
    String  host;
    int port;
    CallBack callBack;
    Socket clientSocket = null;

    Link (String host, int port){
        this.host = host;
        this.port = port;
    }

    public void connect(){
        try {
            clientSocket = new Socket("localhost", 4444);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage (Message message){
        Gson gson = new Gson();
        String json = gson.toJson(message);
        int sizeOfMessageInt = json.length();
        byte[] sizeOfByts = BigInteger.valueOf(sizeOfMessageInt).toByteArray();
        byte[] massOfBytsOfMessage = json.getBytes();
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(sizeOfByts);
            outputStream.write(massOfBytsOfMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
    public void readMessage (){
        byte[] sizeOfMessage = new byte[4];
        while (true) {
            try {
                InputStream inputStream1 = clientSocket.getInputStream();
                int size = inputStream1.read(sizeOfMessage);
                byte[] message = new byte[size];
                InputStream inputStream2 = clientSocket.getInputStream();
                inputStream2.read(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



