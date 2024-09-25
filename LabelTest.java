// A linha abaixo importará o componente JFrame do módulo swing da biblioteca (pacote) javax
import javax.swing.JFrame;

// A linha abaixo está declarando a classe LabelTestet
public class LabelTest 
// A linha abaixo vai iniciar o bloco de códigos da classe LabelTest
{
   // A linha abaixo está declarando o método "main" (principal)
   public static void main(String[] args)
   { 
      // A linha abaixo está declarando a váriavel "labelFrame", de tipo LabelFrame que recebe o novo objeto LabelFrame
      LabelFrame labelFrame = new LabelFrame(); 
      // A linha abaixo está invocado o método setDefaultCloseOperation que definirá a operação de fechamento padrão. Entre o parenteses está enviando o parâmetro (EXIT_ON_CLOSE) 
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // A linha abaixo está definindo o tamanho da labelFrame: 260px de largura e 180px de altura
      labelFrame.setSize(260, 180); 
      // A linha abaixo está definindo a visibilidade da labelFrame como verdadeira
      labelFrame.setVisible(true); 
   // A linha abaixo está sendo encerrado o bloco de código do método "main"
   } 
// A linha abaixo está sendo encerrado o bloco de código da classe LabelTest
}