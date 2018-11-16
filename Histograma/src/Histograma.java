//bibliotecas
import java.awt.BorderLayout;
import java.awt.image.BufferedImage; //Usar a imagem
import java.io.File; //Pode pegar o arquivo
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane; //Usar o JOptionPane


public class Histograma {
	public static void main(String[] args) throws IOException {
        //Variáveis
        BufferedImage imagem = null; //imagem 1
        BufferedImage imagem2 = null; //imagem2
        int clr; //cor1
        int red,green,blue,color, redt=0,bluet=0,greent=0,cort=0; //cores imagem 1
        int clr2; //cor2
        int red2,green2,blue2,color2, redt2=0,bluet2=0,greent2=0,cort2=0; //cores imagem 2
        String local1; //caminho dos arquivos
        String local2;
        
        local1 = JOptionPane.showInputDialog("Digite o local do arquivo com nome do arquivo e sua extensão.\n(Ex: C:\\imagem\\teste.jpg)","Imagem 1");
        //Captura o caminho do arquivo digitado pelo usuário
        
        //Pega o caminho da imagem e define como o valor da variável
        try {
            imagem = ImageIO.read(new File(local1));
        }
        catch (IOException ex) {
        	JOptionPane.showMessageDialog(null, "Não foi possível localizar a imagem 1 !");
        }
        
        //Pegar o tamanho da imagem e define como vetor, um vetor para cada cor RGB
        
        int [][] redg = new int [imagem.getWidth()][imagem.getHeight()];
        int [][] greeng = new int[imagem.getWidth()][imagem.getHeight()];
        int [][] blueg = new int[imagem.getWidth()][imagem.getHeight()];
        int[][] corg = new int[imagem.getWidth()][imagem.getHeight()];
        
        //Caminha por toda a imagem pegando as cores de cada pixel e colocando em um vetor
        for(int x = 0;x < imagem.getWidth(); x++) {
        for(int y= 0;y < imagem.getHeight(); y++) {
            clr=  imagem.getRGB(x,y); 
            red   = (clr & 0xff0000) >> 16;
              green = (clr & 0xff00) >> 8;
              blue  =  clr & 0xff;
              color = (clr & 0xff00000) >>> 24;
            
            redg[x][y] = red;
            greeng[x][y] = green;
            blueg[x][y] = blue;
            corg[x][y] = color;
          
          //Soma todas as cores e soma em um valor total para ser dividido futuramente  
          redt = redt + red;
          greent = greent + green;
          bluet = bluet + blue;
          cort = cort + color;
        }}
        
        //Com a soma das cores ele calcula uma média de cada cor
        
        redt = redt/(imagem.getHeight()*imagem.getWidth());
        greent = greent/(imagem.getHeight()*imagem.getWidth());
        bluet = bluet/(imagem.getHeight()*imagem.getWidth());
        cort = (redt+greent+bluet)/3;
        
        //Imprime para o usuário os valores obtidos da imagem 1
         System.out.println("[Imagem 1]\n\nMédia da cor vermelha = "+ redt + "\n");
         for(int i=1; i<=redt;i++){
                System.out.printf("*");
              }
          System.out.println("\nMédia da cor verde = "+ greent +"\n");
          for(int i=1; i<=greent;i++){
                System.out.printf("*");
              }
          System.out.println("\nMédida da cor azul = "+ bluet + "\n");
          for(int i=1; i<=bluet;i++){
                System.out.printf("*");
              }
          System.out.println("\nMédia das cores = "+ cort);
          for(int i=1; i<=cort;i++){
                System.out.printf("*");
              }
          
          //Ocorre o mesmo processo da imagem 1
          local2 = JOptionPane.showInputDialog("Digite o local do arquivo com nome do arquivo e sua extensão.\n(Ex: C:\\imagem\\teste.jpg)","Imagem 2");
          try {
                imagem2 = ImageIO.read(new File(local2));
            }
            catch (IOException ex) {
            	JOptionPane.showMessageDialog(null, "Não foi possível localizar a imagem 2 !");
            }
            
            int [][] redg2 = new int [imagem2.getWidth()][imagem2.getHeight()];
            int [][] greeng2 = new int[imagem2.getWidth()][imagem2.getHeight()];
            int [][] blueg2 = new int[imagem2.getWidth()][imagem2.getHeight()];
            int[][] corg2 = new int[imagem2.getWidth()][imagem2.getHeight()];
            
            for(int x = 0;x < imagem2.getWidth(); x++) {
            for(int y= 0;y < imagem2.getHeight(); y++) {
                clr2=  imagem2.getRGB(x,y); 
                red2   = (clr2 & 0xff0000) >> 16;
                  green2 = (clr2 & 0xff00) >> 8;
                  blue2  =  clr2 & 0xff;
                  color2 = (clr2 & 0xff00000) >>> 24;
                  redg2[x][y] = red2;
                greeng2[x][y] = green2;
                blueg2[x][y] = blue2;
                corg2[x][y] = color2;
                  redt2 = redt2 + red2;
              greent2 = greent2 + green2;
              bluet2 = bluet2 + blue2;
              cort2 = cort2 + color2;
            }}
            //Calcula a media das cores da imagem 2
            redt2 = redt2/(imagem2.getHeight()*imagem2.getWidth());
            greent2 = greent2/(imagem2.getHeight()*imagem2.getWidth());
            bluet2 = bluet2/(imagem2.getHeight()*imagem2.getWidth());
            cort2 = (redt2+greent2+bluet2)/3;
            
            //Imprime para o usuário os valores obtidos da imagem 2
             System.out.println("\n\n[Imagem2]\n\nMédia da cor vermelha= "+ redt2);
             for(int i=1; i<=redt2;i++){
                    System.out.printf("*");
                  }
              System.out.println("\nMédia da cor verde = "+ greent2);
              for(int i=1; i<=greent2;i++){
                    System.out.printf("*");
                  }
              System.out.println("\nMédia da cor azul = "+ bluet2);
              for(int i=1; i<=bluet2;i++){
                    System.out.printf("*");
                  }
              System.out.println("\nMédia das cores = "+ cort2);
              for(int i=1; i<=cort2;i++){
                    System.out.printf("*");
                  }
              
              
              //Verifica se as médias obtidas das imagens são iguais
              if(redt==redt2&&greent==greent2&&bluet==bluet2&&cort==cort2) {
            	  //Se todos os valores forem iguais, ele imprime a frase abaixo
            	  System.out.println("\nAs imagens são iguais !");
              }
              else {
            	  //Se todos os valores não forem iguais, apresenta a frase abaixo
                  System.out.println("\nAs imagens não são iguais !");
              }              
              
              //Mostra para o usuário as imagens selecionadas
              
              JFrame frame1 = new JFrame();
              JLabel label1 = new JLabel(new ImageIcon(local1));
              frame1.getContentPane().add(label1, BorderLayout.EAST);
              frame1.pack();
              frame1.setVisible(true);
              frame1.setTitle("Imagem 1");
              JFrame frame2 = new JFrame();
              JLabel label2 = new JLabel(new ImageIcon(local2));
              frame2.getContentPane().add(label2, BorderLayout.WEST);
              frame2.pack();
              frame2.setVisible(true);
              frame2.setTitle("Imagem 2");
	}    
}