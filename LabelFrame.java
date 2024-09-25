// Na linha abaixo está sendo importado o componente FlowLayout do módulo awt da biblioteca java
import java.awt.FlowLayout; 
// Nas linhas de 4 à 8 estão sendo importados os componentes necessarios do módulo swing da biblioteca javax
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants;
import javax.swing.Icon; 
import javax.swing.ImageIcon;

// Na linha abaixo está sendo declarada a classe LabelFrame com o mesmo nome do arquivo. o extends significa que a classe está herdando o componente Jframe
public class LabelFrame extends JFrame 
// Na linha abaixo está sendo aberto o bloco de códigos da classe
{
   // Nas linhas abaixo estão sendo declaradas as váriaveis
   private final JLabel label1; // "private" significa que não será exportada a váriavel, ou seja somente estará presente nesse bloco de código. o "final" serve para declarar uma váriavel de somente leitura. "JLabel" é o tipo da váriavel que foi importada no começo do código. "label1" é o nome da váriavel.
   private final JLabel label2;
   private final JLabel label3;

   // Na linha abaixo está sendo declarado o construtor public, que tem o mesmo nome da classe que tem o mesmo nome do arquivo
   public LabelFrame()
   // Na linha abaixo está sendo iniciado o bloco de códigos do construtor
   {
      // Na linha abaixo temos um método de interface
      super("Testando JLabel");// "super" significa que estamos definindo o titulo da janela, vem de superior
      // Na linha abaixo está sendo definido o layout (desenho) da aplicação, está sendo enviado um novo FlowLayout como parâmetro
      setLayout(new FlowLayout());

      label1 = new JLabel("Rotulo com texto");// A label1 está recebendo um novo objeto com uma string "Label with text"
      label1.setToolTipText("This is label1");// A label1 está definindo uma ferramenta de dica de texto, está definindo o que aparecerá quando por o mouse em cima do elemento
      add(label1);// A label1 está sendo adicionado ao construtor


      Icon bug = new ImageIcon(getClass().getResource("bug1.png")); // Declaração da váriavel "bug" do tipo Icon, que está sendo atribuido um novo objeto do tipo ImageIcon, que recebe um parametro com métodos que pegam a clase (getClass()) LabelFrame, e invocar o recurso (getResource()) "bug1.png" (nome do arquivo)
      label2 = new JLabel("Rotulo com texto e icone", bug, 
         SwingConstants.LEFT); // A label2 está recebendo um novo objeto do tipo JLabel, onde estamos enviando o texto e a variavel bug. O próximo parametro (SwingConstants) serve para definir o alinhamento do bug
         // , (virgula) dentro de parenteses serve como separador de parametros
      label2.setToolTipText("This is label2");// Está sendo definido o texto que será apresentado ao passar o mouse
      add(label2); // A label2 está sendo atribuida ao construtor

      label3 = new JLabel(); // A label1 está recebendo um novo objeto JLabel
      label3.setText("Rotulo com texto em baixo"); // Está sendo atribuido o texto da variavel
      label3.setIcon(bug); // Está sendo atribuido a imagem na váriavel
      label3.setHorizontalTextPosition(SwingConstants.CENTER); // Está sendo definido a posição horizontal do texto como CENTER (centro)
      label3.setVerticalTextPosition(SwingConstants.BOTTOM); // Está sendo definido a posição vertical do texto como BOTTOM (baixo)
      label3.setToolTipText("This is label3"); // Está sendo definido o texto que será apresentado ao passar o mouse
      add(label3); // A label3 está sendo atribuida ao construtor
   } // Está sendo fechado o bloco de códigos do construtor
} // Está sendo fechado o bloco de códigos da classe