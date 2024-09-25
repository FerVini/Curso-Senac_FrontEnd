import java.awt.FlowLayout; // Importa o layout de fluxo para organizar os componentes 
import java.awt.event.ActionListener; // Importa a interface ActionListener para gerenciar eventos de ação
import java.awt.event.ActionEvent; // Importa a classe ActionEvent para representar eventos de ação
import javax.swing.JFrame; // Importa a classe JFrame para criar uma janela
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

// Declaração da classe TextFieldFrame que está herdando o componente JFrame
public class TextFieldFrame extends JFrame 
{ // Abertura do bloco de códigos da classe TextFieldFrame
   private final JTextField textField1; // Declaração de váriavel privada, de uso exclusivo da classe, que não pode ser modificada de tipo JTextField 
   private final JTextField textField2; // Declaração de váriavel privada, de uso exclusivo da classe, que não pode ser modificada de tipo JTextField
   private final JTextField textField3; // Declaração de váriavel privada, de uso exclusivo da classe, que não pode ser modificada de tipo JTextField
   private final JPasswordField passwordField; // Declaração de váriavel privada, de uso exclusivo da classe, que não pode ser modificada de tipo JPasswordField

   public TextFieldFrame() // Declaração do construtor, onde tiver "public" significa que está sendo exportado
   { // Abertura do bloco de códigos do construtor
      super("Testing JTextField and JPasswordField"); //Definição do titulo que será apresentado na janela
      setLayout(new FlowLayout()); // Definição do Fluxo do layout, o que for renderizado primeiro será apresentado primeiro

      textField1 = new JTextField(10); // Atribuição de váriavel textField que recebe um novo campo de texto com o tamanho sendo definido por 10 colunas
      add(textField1); // Está sendo adicionado na renderização da janela

      textField2 = new JTextField("Enter text here"); // Atribuição de váriavel textField2 que recebe um novo campo de texto que tem o tamanho definido pelo texto
      add(textField2); // Está sendo adicionado na renderização da janela

      textField3 = new JTextField("Uneditable text field", 21); // Atribuição de váriavel textField3 que recebe um novo campo de texto que tem o tamanho definido por texto e colunas
      textField3.setEditable(false); // Define que esse textField não seja editado por conta do "false"
      add(textField3); // Está sendo adicionado na renderização da janela

      passwordField = new JPasswordField("Hidden text"); // Atribuição de um novo objeto do tipo JPasswordField que esconde o texto
      add(passwordField); // Está sendo adicionado na renderização da janela

      TextFieldHandler handler = new TextFieldHandler(); // Está sendo declarada a variavel handler atribuido um manipulador (TextFieldHandler) dos campos de texto
      // Nas linhas abaixo estão sendo adicionados um escutador de ação 
      textField1.addActionListener(handler); 
      textField2.addActionListener(handler);
      textField3.addActionListener(handler);
      passwordField.addActionListener(handler);
   } // Encerramento do bloco de códigos do construtor

   // Declaração de classe privativa da classe original, e injeção do objeto dentro da classe
   private class TextFieldHandler implements ActionListener 
   { // Inicio do bloco de códigos da classe TextFieldHandler
      @Override // Usamos o @ antes para que ignore algumas mensagens de aviso e o Override é utilizado para sobrescrever o método dentro do objeto
      public void actionPerformed(ActionEvent event) // Declaração do método publico que pode ser importado, void que não haverá retorno
      { // Inicio do bloco de código do método actionPerformed
         String string = ""; // Declaração de uma variavel string do tipo String que está sendo atribuido um texto vazio ""
         if (event.getSource() == textField1) // if é um algoritimo de validação que compara se o evento de ação é igual a váriavel textField1 e retorna a mensagem correspondente
            string = String.format("textField1: %s", // está sendo atribuido o metodo .format que entrega o texto formatado na váriavel string. (%s) é um caractere coringa, o "s" significa que será retornado um texto
               event.getActionCommand()); // O segundo parametro está pegando o comando da ação e enviando o que está digitado dentro do textField1

         else if (event.getSource() == textField2) 
            string = String.format("textField2: %s",
               event.getActionCommand());

         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         JOptionPane.showMessageDialog(null, string); // Está sendo invocado o metodo e pedindo para mostrar uma caixa de dialogo, como parametros está recebendo o compoente pai null (nenhum) e a string 
      } // Encerramento do bloco de código actionPerformed
   } // Encerramento do bloco de código da classe TextFieldHandler
} // Encerramento do bloco de código da classe TextFieldFrame