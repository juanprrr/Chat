import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    // server is listening on port 5000
    private int port;
    private Map<Integer, ServerStream> serverStreams = new HashMap<Integer, ServerStream>();
    private Window window;


    public Server(int port, Window window){
        this.window = window;
        this.port = port;
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            // client request
            while(true){
                System.out.println("Connecting Client---");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to: " + clientSocket.getPort());
                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                serverStreams.put(clientSocket.getPort(), new ServerStream(clientSocket, dos, dis, this.window));
                serverStreams.get(clientSocket.getPort()).start();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
