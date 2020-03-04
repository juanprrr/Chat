import javax.swing.*;

public class Client extends javax.swing.JFrame {
    private JButton sendButton;
    private JTextField idText;
    private JTextArea textArea;
    private JTextField ip;
    private JPanel Client;
    private JButton connectToServerButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Client");
        frame.setContentPane(new Client().Client);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
