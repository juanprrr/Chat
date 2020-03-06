import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private int port;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private Map<Integer, ServerStream> serverStreams = new HashMap<Integer, ServerStream>();

    public Client (int port, DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;

        try{
            Socket socket = new Socket("localhost",port);
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
