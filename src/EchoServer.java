import com.sun.security.ntlm.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while((inputLine = in.readLine()) != null){
            if(".".equals(inputLine)){
                out.println("good bye");
                break;
            }
            out.println(inputLine);
        }
    }

    public static void main(String[] args) throws IOException {
        EchoServer server = new EchoServer();
        server.start(6666);
    }
}
