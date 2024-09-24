//Na linha abaixo está importando a biblioteca (pacote) javax, o módulo swing e o componente JOptionPane
import javax.swing.JOptionPane; 

//Na linha abaixo está sendo declarada a classe Addition
public class Addition 
//Na linha abaixo está sendo aberto o bloco de códigos da classe Addition
{
   //Na linha abaixo está sendo declarado o método "main" (principal) que vai executar a aplicação
   public static void main(String[] args)
   //Na linha de baixo está sendo aberto o bloco de códigos do método "main"
   {
      //Na linha abaixo está sendo declarada a váriavel, de tipo "String", do primeiro número (firstNumber). Onde tem operador de atribuição está sendo declarado uma váriavel
      String firstNumber = 

         //Na linha abaixo está sendo invocado o Objeto JOptionPane e utilizando o método (showInputDialog) para mostrar uma mensagem na aplicação
         JOptionPane.showInputDialog("Digite o primeiro número inteiro");

      //Na linha abaixo está sendo declarada a váriavel, de tipo "String", do segundo número (secondNumber)
      String secondNumber =
      
         //Na linha abaixo está sendo invocado o objeto JOptionPane e utilizando o método (showInputDialog) para mostrar uma mensagem na aplicação
          JOptionPane.showInputDialog("Digite o segundo número inteiro");
          
      //Na linha abaixo está havendo a conversão da váriavel que é "String" (texto) para "Number" (número)
      int number1 = Integer.parseInt(firstNumber); 

      //Na linha abaixo está havendo a conversão da váriavel que é "String" (texto) para "Number" (número)
      int number2 = Integer.parseInt(secondNumber);

      //Na linha abaixo está sendo declarado uma váriavel inteira que recebe a soma dos dois numeros
      int sum = number1 + number2; 

      //Na linha abaixo está sendo passado a mensagem que será apresentado no final da aplicação
      JOptionPane.showMessageDialog(null, "A Soma é " + sum, 

         //Na linha abaixo está sendo declarado o titulo da aplicação
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   //Na linha abaixo está sendo fechado o bloco de códigos do método "main"
   } 
//Na linha abaixo está sendo fechado o bloco de códigos da class "Addition"
} 
