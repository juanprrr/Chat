import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**This class allows the transmission of data to the connected clients
 */
public class ServerStream {
    private Socket socket;
    private ServerSocket serverSocket;
    private InputStreamReader din;
    private DataOutputStream dout;
    private BufferedReader input;
    private int port = 40000;

    public ServerStream() {
        try {
            serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
/**Din and input instances get the incoming data and read it.
 *
 */         din = new InputStreamReader(socket.getInputStream());
            input = new BufferedReader(din);
/**Dout instance is for data output
 *
 */
            dout = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ServerStream(String ip) throws IOException {
        try{
            socket = new Socket(ip, this.port);

            din = new InputStreamReader(socket.getInputStream());
            input = new BufferedReader(din);

            dout = new DataOutputStream(socket.getOutputStream());

    }
        catch (IOException e) {e.printStackTrace();}
    }

    public void sendMsg(String msg){
        try{
            dout.writeUTF(msg);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public String readMsg(){
        try {
            return input.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void offline(){
        try{
            socket.close();
            serverSocket.close();
            }catch (IOException e) {e.printStackTrace();}

        }
}


