import javax.swing.*;
import java.io.*;
import java.util.*;
import java.net.*;

/** Class Server: creates a server socket that listens to a specific port, once there´s communication, the streamServer handles the communication with the client Socket
 * @author Juan P. Rostran
 *
 */
public class Server extends javax.swing.JFrame {
    private JButton msg_send;
    private JTextField msg_text;
    private JTextArea msg_area;
    private JButton startServer;
    private JPanel Server;
    public static void main(String[] args) {
        int port = 40000;
        try {
            ServerSocket serverSocket= new ServerSocket(port);
            while(true){
                System.out.println("Connecting Client---");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected");
                ServerStream streamer = new ServerStream(clientSocket);
                streamer.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
