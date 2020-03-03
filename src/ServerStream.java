import java.io.*;
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
    /**This function is able to read whatever the client writes, and it returns the message. It's a kind of mirror.
     */
    private void threadClientSocket(Socket clientSocket) throws IOException, InterruptedException {
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));
        String line;
        while((line = reader.readLine()) != null){
            if ("Exit".equalsIgnoreCase(line)){
                break;
            }
            String msg = "You wrote:" + line + "\n";
            outputStream.write(msg.getBytes());

        }
        clientSocket.close();
    }
}

