// Importação dos componentes
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame // Declaração de classe pública com herança do JFrame
{ // Abertura do bloco de códigos
   private final JList<String> colorJList; // Declaração de variável privativa da classe que não pode ser alterada que armazena uma lista de strings
   private static final String[] colorNames = {"Black", "Blue", "Cyan", // Declaração de váriavel privativa de uso exclusivo da classe e que não pode ser alterado que recebe uma matriz de strings
   "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
   "Orange", "Pink", "Red", "White", "Yellow"};
   private static final Color[] colors = {Color.BLACK, Color.BLUE, // Declaração de váriavel privativa e de uso exclusivo da classe e que não pode ser alterado que recebe uma matriz de cores
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW};
      
   private final JList<String> tamanhoList; // Declaração de variável privativa da classe que não pode ser alterada que armazena uma lista de strings
   private static final String[] tamanhoNames = {"Small", "Medium", "Big"};
   
   public ListFrame() // Declaração do método construtor
   { // Abertura do bloco de códigos
      super("List Test"); // Declaração do titulo da janela
      setLayout(new FlowLayout()); // Define o fluxo de apresentação da pagina
      
      colorJList = new JList<String>(colorNames); // Atribuição de uma matriz de string à variável com o parametro o nome das cores
      colorJList.setVisibleRowCount(5); // Definição de quantas linhas serão visiveis quando abrir as opções do colorJList
   
      tamanhoList = new JList<String>(tamanhoNames);

      tamanhoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Define quantas opções são possiveis selecionar por vez, no caso apenas uma

      add(new JScrollPane(tamanhoList)); 
      
      add(new JScrollPane(colorJList)); // Adiciona um novo objeto do tipo JScrollPane que recebe parametro (colorJList)
      
      colorJList.addListSelectionListener( // Adiciona o escutador de lista de seleção ao colorJList
         new ListSelectionListener() // Objeto
         {   
            
            @Override // Execução sobreescrita do método
            public void valueChanged(ListSelectionEvent event) // Declaração de método que recebe o parametro event do ListSelectionEvent
            {
               getContentPane().setBackground( // Pega o painel de conteudo e define o fundo de acordo com o numero selecionado
                  colors[colorJList.getSelectedIndex()]);
            } 
         } 
      ); 
      tamanhoList.addListSelectionListener( // Adiciona o escutador de lista de seleção ao colorJList
         new ListSelectionListener() // Objeto
         {   
            
            @Override // Execução sobreescrita do método
            public void valueChanged(ListSelectionEvent event) // Declaração de método que recebe o parametro event do ListSelectionEvent
            {
               switch (tamanhoList.getSelectedIndex()) {
                  case 0:
                     setSize(350, 150);
                     break;

                  case 1:
                     setSize(550, 350);
                     break;

                  case 2:
                     setSize(750, 550);
                     break;

                  default:
                     setSize(350,150);
                     break;
               }
            } 
         } 
      ); 
   }   
} 
