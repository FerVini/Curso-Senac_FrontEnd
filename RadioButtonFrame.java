// Importação dos componentes 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonFrame extends JFrame // Declaração da classe publica RadioButtonFrame e que herda a classe JFrame
{ // Abertura de código da classe

   // Nas linhas abaixo estão sendo declaradas as variáveis
   private JTextField textField; 

   private Font plainFont; 
   private Font boldFont; 
   private Font italicFont;
   private Font boldItalicFont;
   
   private JRadioButton plainJRadioButton; 
   private JRadioButton boldJRadioButton; 
   private JRadioButton italicJRadioButton;
   private JRadioButton boldItalicJRadioButton;
   private ButtonGroup radioGroup; 
   
   private Color blackColor; 
   private Color redColor; 
   private Color blueColor;
   private Color yellowColor;
   
   private JRadioButton blackJRadioButton; 
   private JRadioButton redJRadioButton; 
   private JRadioButton blueJRadioButton;
   private JRadioButton yellowJRadioButton;

   private ButtonGroup colorRadioGroup;

   public RadioButtonFrame() // Abertura do construtor
   {
      super("RadioButton Test"); // Definição do titulo apresentado no topo da página
      setLayout(new FlowLayout());  // Definição o layout da página

      textField = new JTextField("Watch the font style change", 25); // Atribuição do campo de texto e tamanho apresentado na variavel textField
      add(textField); // Adição da váriavel ao container

      plainJRadioButton = new JRadioButton("Plain", true); // Atribuição do botão do tipo padrão com os parametros nome("Plain") e true que declara ele ativo
      boldJRadioButton = new JRadioButton("Bold", false); // Atribuição do botão do tipo negrito com os parametros nome("Bold") e false que declara ele desativado
      italicJRadioButton = new JRadioButton("Italic", false); // Atribuição do botão do tipo italic com os parametros nome("Italic") e false que declara ele desativado
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false); // Atribuição do botão dos tipo negrito e italico com os parametros nome("Bold/Italic") e false que declara ele desativado
      add(plainJRadioButton); // Adição da variável ao container 
      add(boldJRadioButton); // Adição da variável ao container 
      add(italicJRadioButton); // Adição da variável ao container 
      add(boldItalicJRadioButton); // Adição da variável ao container

      radioGroup = new ButtonGroup(); // Atribuição de um novo objeto à variável 
      radioGroup.add(plainJRadioButton); // Adição da variável ao objeto  
      radioGroup.add(boldJRadioButton); // Adição da variável ao objeto  
      radioGroup.add(italicJRadioButton); // Adição da variável ao objeto  
      radioGroup.add(boldItalicJRadioButton); // Adição da variável ao objeto  

      plainFont = new Font("Sans-Serif", Font.PLAIN, 14); // Atribuição do objeto à variável com parâmetros de estilização
      boldFont = new Font("Sans-Serif", Font.BOLD, 14); // Atribuição do objeto à variável com parâmetros de estilização
      italicFont = new Font("Sans-Serif", Font.ITALIC, 14); // Atribuição do objeto à variável com parâmetros de estilização
      boldItalicFont = new Font("Sans-Serif", Font.BOLD + Font.ITALIC, 14); // Atribuição do objeto à variável com parâmetros de estilização
      textField.setFont(plainFont); // Definição do estilo do textField

      // Atribuição do escutador ao objeto RadioButtonHandler
      plainJRadioButton.addItemListener( 
         new RadioButtonHandler(plainFont)); 
      boldJRadioButton.addItemListener(
         new RadioButtonHandler(boldFont));
      italicJRadioButton.addItemListener(
         new RadioButtonHandler(italicFont));
      boldItalicJRadioButton.addItemListener(
         new RadioButtonHandler(boldItalicFont));

      blackJRadioButton = new JRadioButton("Black", true); 
      redJRadioButton = new JRadioButton("Red", false); 
      blueJRadioButton = new JRadioButton("Blue", false); 
      yellowJRadioButton = new JRadioButton("Yellow", false); 
      add(blackJRadioButton); 
      add(redJRadioButton); 
      add(blueJRadioButton); 
      add(yellowJRadioButton); 

      colorRadioGroup = new ButtonGroup(); 
      colorRadioGroup.add(blackJRadioButton); 
      colorRadioGroup.add(redJRadioButton); 
      colorRadioGroup.add(blueJRadioButton); 
      colorRadioGroup.add(yellowJRadioButton); 

      blackColor = Color.black; 
      redColor = Color.red; 
      blueColor = Color.blue; 
      yellowColor = Color.yellow; 

      textField.setForeground(blackColor); 

      
      blackJRadioButton.addItemListener( 
         new ColorRadioButtonHandler(blackColor)); 
      redJRadioButton.addItemListener(
         new ColorRadioButtonHandler(redColor));
      blueJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blueColor));
      yellowJRadioButton.addItemListener(
         new ColorRadioButtonHandler(yellowColor));
   

   } 

   private class ColorRadioButtonHandler implements ItemListener 
   {
      private Color color;

      public ColorRadioButtonHandler(Color c)
      {
         color = c; 
      } 
   
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setForeground(color);
      }
   }

   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // Definição da variável font do tipo Font

      public RadioButtonHandler(Font f) // Declaração do construtor
      {
         font = f; 
      } 
   
      @Override
      public void itemStateChanged(ItemEvent event) // Declaração do método que está sendo sobreescrito
      {
         textField.setFont(font); // Define qual fonte será mostrada
      }
   }
}