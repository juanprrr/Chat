import javax.swing.*;
import java.io.*;
import java.util.*;
import java.net.*;


public class Server {
    private JButton msg_send;
    private JTextField msg_text;
    private JTextArea msg_area;
    private JTextPane connectedClients;

    public static void main(String[] args) {
        int port = 9000;
        try {
            ServerSocket serverSocket= new ServerSocket(port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write("Hola mundo\n".getBytes());
                clientSocket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
