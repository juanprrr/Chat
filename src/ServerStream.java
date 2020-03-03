import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
/**This class is a Thread that allows the transmission of data to the connected clients
 */
public class ServerStream extends Thread {

    private final Socket clientSocket;
    public ServerStream(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            threadClientSocket(clientSocket);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void threadClientSocket(Socket clientSocket) throws IOException, InterruptedException {
        OutputStream outputStream = clientSocket.getOutputStream();
        //outputStream.write("Hola mundo\n".getBytes());
        for (int i = 0; i<10; i++){
            outputStream.write(("Time" + new Date() + "\n").getBytes());
            Thread.sleep(1000);
        }
        clientSocket.close();
    }
}

