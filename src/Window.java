import javax.swing.*;

public class Window extends javax.swing.JFrame {
    private JButton sendButton;
    private JTextField idText;
    private JTextArea textArea;
    private JTextField port;
    private JPanel Window;
    private JButton testConnectionButton;

    public void init() {
        JFrame frame = new JFrame("Window");
        frame.setContentPane(this.Window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JTextField getPort() {
        return port;
    }
}
