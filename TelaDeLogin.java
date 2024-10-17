import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeLogin extends JFrame {
    private final JLabel lblLogin;
    private final JLabel lblSenha;

    private final JTextField txtLogin;
    private final JPasswordField txtSenha;

    private final JButton btnLogar;

    public TelaDeLogin() {
        super("Tela de Login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("Login:");
        lblLogin.setToolTipText("Login");
        add(lblLogin);

        txtLogin = new JTextField(15);
        add(txtLogin);

        lblSenha = new JLabel("Senha:");
        lblSenha.setToolTipText("Senha");
        add(lblSenha);

        txtSenha = new JPasswordField(15);
        add(txtSenha);

        btnLogar = new JButton("Login");
        add(btnLogar);
    }
    
    public static void main(String[] args){
        TelaDeLogin appTelaDeLogin = new TelaDeLogin();
        appTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appTelaDeLogin.setSize(200, 250);
        appTelaDeLogin.setVisible(true);
    }
}