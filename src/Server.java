import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // server is listening on port 5000
    private static int port = 5000;
    private ServerStream serverStream;

    public Server(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            port ++;

            // client request
            while(true){
                System.out.println("Connecting Client---");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to: " + clientSocket.getPort());
                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());



            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
