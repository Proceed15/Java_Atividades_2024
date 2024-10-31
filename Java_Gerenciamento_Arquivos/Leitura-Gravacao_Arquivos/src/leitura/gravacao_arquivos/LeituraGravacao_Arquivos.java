/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leitura.gravacao_arquivos;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class LeituraGravacao_Arquivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int op=0;
        String arquivo="", linha="", texto="";
        String diretorio;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(
            "Manipulação de Arquivos de Texto\n"+
                    "1 - Informar o nome do arquivo texto\n" +
                    "2 - Fazer leitura de Dados\n" +
                    "3 - Escrever dados\n" + 
                    "4 - Sair"       
            ));
            switch(op){
                case 1: 
                    diretorio="C:\\Users\\0031432412016\\desktop\\";
                    arquivo=JOptionPane.showInputDialog(
                    "Informe o nome do arquivo (com extensão):");
                    arquivo = diretorio + arquivo;
                    break;
                case 2:
                    if(!arquivo.equals("")){
                        leituraArquivo lerArq = new leituraArquivo(arquivo);
                        linha = lerArq.getLinha();
                        while (linha != null) {
                            texto += linha + "\n";

                            linha = lerArq.getLinha(); // lê da segunda até a última linha
                        }
                        JOptionPane.showMessageDialog(null, texto);
                    }else{
                        JOptionPane.showMessageDialog(null, "Informar o nome do arquivo!");
                    }
                    break;
                case 3:
                    if(!arquivo.equals("")){
                        Gravacao gravaArq = new Gravacao(arquivo);
                        texto = JOptionPane.showInputDialog("Informe o texto a ser inserido:");
                        gravaArq.escreveLinha(texto);
                    }else{
      
                        JOptionPane.showMessageDialog(null, "Informar o nome do arquivo!");
                    }
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }while(op!=4);
    }
    
}