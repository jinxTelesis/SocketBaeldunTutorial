import java.net.Socket;
import java.io.*;

public class GreetClient {
    private Socket clintSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clintSocket = new Socket(ip, port);
        out = new PrintWriter(clintSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clintSocket.getInputStream()));

    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clintSocket.close();
    }
}
