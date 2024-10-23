import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeCadastro extends JFrame{

    private final JLabel lblNome;
    private final JLabel lblEmail;
    private final JLabel lblSenha;
    private final JLabel lblNotificacoes;
    

    private final JTextField txtNome;
    private final JTextField txtEmail;
    private final JPasswordField txtSenha;

    private final JButton btnCadastrar;
    private final JButton btnCancelar;

    public TelaDeCadastro() {
        super("Tela de cadastro");
        setLayout(new GridLayout(5, 1, 5, 5));

        JPanel linhaNome = new JPanel(new GridLayout(1, 2));
        
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        txtNome = new JTextField(10);

        linhaNome.add(lblNome);
        linhaNome.add(txtNome);
        
        add(linhaNome);


        JPanel linhaEmail = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        txtEmail = new JTextField(20);

        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);

        add(linhaEmail);


        JPanel linhaSenha = new JPanel(new GridLayout(1, 2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        txtSenha = new JPasswordField(10);

        linhaSenha.add(lblSenha);
        linhaSenha.add(txtSenha);

        add(linhaSenha);


        JPanel linhaBotao = new JPanel(new GridLayout(1, 2));
        
        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");
        
        linhaBotao.add(btnCadastrar);
        linhaBotao.add(btnCancelar);
        
        add(linhaBotao);


        JPanel linhaNotificacao = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("A notificação vai aqui!", SwingConstants.CENTER);
        
        linhaNotificacao.add(lblNotificacoes);

        add(linhaNotificacao);

        btnCadastrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event){
                    if(txtNome.getText().trim().length() == 0){ // Verifica se a resposta é válida
                        lblNotificacoes.setText("Insira uma resposta válida no campo NOME.");
                        txtNome.requestFocus();
                        return;
                    }
                    if(txtEmail.getText().trim().length() == 0){ // Verifica se a resposta é válida
                        lblNotificacoes.setText("Insira uma resposta válida no campo EMAIL.");
                        txtEmail.requestFocus();
                        return;
                    }
                    if(String.valueOf(txtSenha.getPassword()).trim().length() == 0){ // Verifica se a resposta é válida
                        lblNotificacoes.setText("Insira uma resposta válida no campo SENHA.");
                        txtSenha.requestFocus();
                        return;
                    }

                    String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + txtNome.getText() + "', '" + txtEmail.getText() + "', '" + String.valueOf(txtSenha.getPassword()) + "');";
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        Statement stmSqlCadastrar = conexao.createStatement();
                        stmSqlCadastrar.addBatch(strSqlCadastrar);
                        stmSqlCadastrar.executeBatch();
                        lblNotificacoes.setText("Cadastro realizado com sucesso!");
                    } catch (Exception e){
                        lblNotificacoes.setText("Ops! Ocorreu um problema e não será possível cadastrar nesse momento. Por favorm tente novamente mais tarde.");
                        System.err.println("Erro: " + e);
                    }

                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent event){
                    txtNome.setText("");
                    txtEmail.setText("");
                    txtSenha.setText("");

                    if(JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?") == 0) {
                        System.exit(0);
                    } else {
                        txtNome.requestFocus();
                    }
                }
            }
        );

        setSize(300,300);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new TelaDeCadastro();
    }
}