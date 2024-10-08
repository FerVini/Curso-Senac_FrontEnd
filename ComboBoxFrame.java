// Importação de componentes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame // Declaração da classe publica com herança do JFrame
{ // Abertura do bloco de códigos da classe
   private final JComboBox<String> imagesJComboBox; // Declaração de variável privativa da classe do tipo JComboBox
   private final JLabel label; // Declaração de variável privativa do tipo JLabel

   private static final String[] names = // Declaração de variável com atribuição de uma matriz contendo os endereços dos arquivos necessários
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { // Declaração de variável com atribuição de uma matriz de icones e parâmetros que pegam cada um dos itens da variável names
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   
   public ComboBoxFrame() // Declaração do método construtor
   {
      super("Testing JComboBox"); // Declaração do titulo da janela
      setLayout(new FlowLayout()); // Definição do layout apresentado

      imagesJComboBox = new JComboBox<String>(names); // Declaração de variável com atribuição de um novo objeto JComboBox que recebe a variável de matriz names com tipo String
      imagesJComboBox.setMaximumRowCount(3); // Definição do máximo de contagem de linhas

      imagesJComboBox.addItemListener( // Adiciona um escutador de item à variável imagesJComboBox
         new ItemListener() // Definição de um novo objeto ItemListener
         { // Inicio do bloco de códigos do new ItemListener
            
            @Override // Utilizado para sobreescrever
            public void itemStateChanged(ItemEvent event) // Declaração de um método de estádo de mudança do item que recebe o parâmetro ItemEvent event
            { // Abertura do bloco de códigos do método
               
               if (event.getStateChange() == ItemEvent.SELECTED) // Utiliza lógica de validação que compara os itens e executa o bloco de códigos dentro dele caso seja verdadeiro
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]);
            } // Fecha o bloco de códigos do método
         } // Fecha o bloco de códigos do new ItemListener
      ); 

      add(imagesJComboBox); // Adiciona à renderização
      label = new JLabel(icons[0]); // Seleciona a imagem que será apresentada 
      add(label); // Adiciona à renderização
   }
} 