import javax.swing.JFrame; //Está importando o componente JFrame do módulo swing da biblioteca javax
      //biblioteca > módulo > componente

// Está sendo declarado a classe TextFieldTest (com o mesmo nome do arquivo)     
public class TextFieldTest
//inicio do bloco de códigos da classe TextFieldTest
{
   public static void main(String[] args) // Declaração do método "main" (principal), conhecido também como método executor
   { // Inicio do bloco de códigos do método "main"
      TextFieldFrame textFieldFrame = new TextFieldFrame(); // Declaração de váriavel textFieldFrame de tipo TextFieldFrame atribuido um novo objeto, com o construtor da classe 
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Está sendo definido a operação de fechamento padrão (EXIT_ON_CLOSE dentro do JFrame)
      textFieldFrame.setSize(350, 100); // Está sendo definido o tamanho da váriavel
      textFieldFrame.setVisible(true); // Está sendo definido a visibilidade
   } //Encerramento do bloco de códigos do método "main"
} //Encerramento do bloco de códigos da classe