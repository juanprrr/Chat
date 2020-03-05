import java.io.*;
import java.net.Socket;
/**This class is a Thread that allows the transmission of data to the connected clients
 * @author J.Peña
 * @param
 */
public class ServerStream extends Thread {
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final Socket clientSocket;
    private Boolean running = true;
    private String returned;


    /**Server class constructor
     * @author J.Peña
     * @param  clientSocket
     * @param dos
     * @param dis
     * @return
     */
    public ServerStream(Socket clientSocket, DataOutputStream dos, DataInputStream dis) {
        this.clientSocket = clientSocket;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        try{
            BufferedReader reader = new BufferedReader((new InputStreamReader(dis)));
            while(running){
                String line= reader.readLine();
                switch (line){
                    case "EXIT":
                        clientSocket.close();
                        running = false;
                        break;
                    case "TESTING":
                        dos.writeUTF("SUCCESS");
                        break;
                    default:
                        //TODO: SEND TO GUI
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void sendMsg(String msg){
        try{
            dos.writeUTF(msg);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

