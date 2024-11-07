/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituragravacaoarquivosmodificado;

/**
 *
 * @author 0031432412016
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeituraGravacaoArquivosModificado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int op=0;
        String arquivo="", linha="", texto="";
        String diretorio;
        File arquivoSelecionado=null;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(
            "Manipulação de Arquivos de Texto\n"+
                    "1 - Informe o nome do arquivo texto\n" +
                    "2 - Abrir arquivo texto\n" +
                    "3 - Escrever dados\n" + 
                    "4 - Fazer leitura de Dados\n" +
                    "5 - Sair"       
            ));
            switch(op){
                case 1:
                    diretorio="C:\\Users\\0031432412016\\Desktop\\testes_EtDs\\";
                    arquivo=JOptionPane.showInputDialog(
                        "Informe o nome do arquivo:");
                    arquivo = diretorio + arquivo;
                    break;
                case 2:
                     JFileChooser fileChooser = new JFileChooser();
                     fileChooser.setDialogTitle("Selecione um arquivo .txt para abrir");

                     int userSelection = fileChooser.showOpenDialog(null);

                     if (userSelection == JFileChooser.APPROVE_OPTION) {
                        arquivoSelecionado = fileChooser.getSelectedFile();
                     } else {
                       System.out.println("Nenhum arquivo foi selecionado.");
                     }
                    break;
                //Sempre Escrever Antes da leitura, para que o arquivo seja criado no diretório pelo Windows
                case 3:
                    if(arquivoSelecionado !=null){
                        gravacaoArquivos gravaArq = new gravacaoArquivos(arquivoSelecionado);
                        texto = JOptionPane.showInputDialog("Informe o texto a ser inserido:");
                        gravaArq.escreveLinha(texto);
                        
                        gravaArq.fechar();
                    }else{
      
                        JOptionPane.showMessageDialog(null, "Abra o arquivo primeiro!");
                    }
                    break;
                case 4:
                    if(arquivoSelecionado !=null){
                        leituraArquivos lerArq = new leituraArquivos(arquivoSelecionado);
                        texto = "";
                        linha = lerArq.getLinha();
                        while (linha != null) {
                            texto += linha + "\n";

                            linha = lerArq.getLinha(); // lê da segunda até a última linha
                        }
                        JOptionPane.showMessageDialog(null, texto);
                        lerArq.fechar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Abra o arquivo primeiro!");
                    }
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }while(op!=5);
    }
    
}
