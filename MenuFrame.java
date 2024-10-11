// importação de componentes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame // Declaração da classe que está herdando o JFrame
{ // Abertura do bloco de códigos
   private final Color[] colorValues = // Declaração de variável exclusiva da classe, de somente leitura que recebe uma matriz de cores
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};   // Declaração de vetores da matriz
   private final JRadioButtonMenuItem[] colorItems; 
   private final JRadioButtonMenuItem[] fonts; 
   private final JCheckBoxMenuItem[] styleItems; 
   private final JLabel displayJLabel; 
   private final ButtonGroup fontButtonGroup; 
   private final ButtonGroup colorButtonGroup; 
   private int style; 

   
   public MenuFrame() // Declaração do construtor
   { // Abertura do bloco de códigos
      super("Using JMenus"); // Declaração do titulo da página

      JMenu fileMenu = new JMenu("File"); // Declaração de variável do tipo JMenu e atribuição de um novo objeto 
      fileMenu.setMnemonic('F'); // Definição de um atalho de teclado

      
      JMenuItem aboutItem = new JMenuItem("About..."); // Declaração de variável do tipo JMunuItem e atribuição de um novo objeto
      aboutItem.setMnemonic('A'); // Definição de um atalho de teclado
      fileMenu.add(aboutItem); // Adiciona o aboutItem ao fileMenu
      aboutItem.addActionListener( // Adiciona um escutador de ação
         new ActionListener() 
         {  
            
            @Override // Sobrescreve o actionPerformed
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame.this, // Acessa o painel de opções e mostra a mensagem
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit"); // Declaração de variável do tipo JMenuItem que recebe um novo objeto
      exitItem.setMnemonic('x'); // Definição de um atalho de teclado
      fileMenu.add(exitItem); // Adição do item ao menu desejado
      exitItem.addActionListener( // Atribuição do escutador de ação
         new ActionListener() // Declaração de objeto
         {  
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0); // Sai do sistesma
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // Declaração de variável do tipo JMenuBar (barra de menus) com um novo objeto
      setJMenuBar(bar); // Define uma barra de menu
      bar.add(fileMenu); // Adiciona o fileMenu à barra de menus

      JMenu formatMenu = new JMenu("Format"); // Define um novo menu
      formatMenu.setMnemonic('r'); // Define o atalho do menu

      
      String[] colors = {"Black", "Blue", "Red", "Green"}; // Declaração de uma matriz de strings

      JMenu colorMenu = new JMenu("Color"); // Declaração do menu Color
      colorMenu.setMnemonic('C'); // Define o atalho do menu

      
      colorItems = new JRadioButtonMenuItem[colors.length]; // Declaração de uma matriz 
      colorButtonGroup = new ButtonGroup(); // Atribuição de um novo objeto
      ItemHandler itemHandler = new ItemHandler(); // Declaração de variável com atribuição de um novo objeto

      
      for (int count = 0; count < colors.length; count++) // Estrutura de repetição que constroi os radios buttons do colorMenu
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); 
         colorMenu.add(colorItems[count]); 
         colorButtonGroup.add(colorItems[count]); 
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); // Seleciona o primeiro item

      formatMenu.add(colorMenu); // Adiciona o menu de cor ao menu de formato
      formatMenu.addSeparator(); // Adiciona uma linha que separa os item dentro do menu

      
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"}; // Declara uma variável matriz
      JMenu fontMenu = new JMenu("Font");  // Declara uma variável tipo JMenu
      fontMenu.setMnemonic('n'); // Define a tecla de atalho
      
      fonts = new JRadioButtonMenuItem[fontNames.length]; // Define a matriz de botões de menu
      fontButtonGroup = new ButtonGroup(); // atribuição de um novo ButtoGroup

      
      for (int count = 0; count < fonts.length; count++) // Declara uma estrutura de repetição pré-definida que contrói os itens do menu de items
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]); 
         fontButtonGroup.add(fonts[count]); 
         fonts[count].addActionListener(itemHandler); 
      } 

      fonts[0].setSelected(true); 
      fontMenu.addSeparator(); 

      String[] styleNames = {"Bold", "Italic"}; 
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); 

      
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); 
         fontMenu.add(styleItems[count]); 
         styleItems[count].addItemListener(styleHandler); 
      }

      formatMenu.add(fontMenu); 
      bar.add(formatMenu); 
     
      
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.CYAN); 
      add(displayJLabel, BorderLayout.CENTER); 
   } 

   
   private class ItemHandler implements ActionListener 
   {
      
      @Override
      public void actionPerformed(ActionEvent event)
      {
         
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint(); 
      } 
   } 

   
   private class StyleHandler implements ItemListener 
   {
      
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); 
         Font font; 

         
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint(); 
      } 
   } 
} 