// Importação de componentes
import javax.swing.*;

public class MenuTest // Declaração de classe
{
   public static void main(String[] args) // Declaração de método
   { 
      MenuFrame menuFrame = new MenuFrame(); // Declaração variável com  atribuição de um novo objeto
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o encerramento padrão da janela
      menuFrame.setSize(500, 200); 
      menuFrame.setVisible(true);
   } 
} 