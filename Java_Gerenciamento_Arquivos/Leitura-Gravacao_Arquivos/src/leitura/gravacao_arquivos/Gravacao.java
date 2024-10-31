/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitura.gravacao_arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Gravacao {
    private FileWriter arq;
    private PrintWriter gravarArq;
   
    Gravacao(String nomeArq)throws IOException{
        try {
            arq = new FileWriter(nomeArq);
            gravarArq = new PrintWriter(arq); 
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
        }
    }
    void escreveLinha(String texto){
        gravarArq.print(texto);
    }
    void fechar()throws IOException{
        arq.close();
    }
    
    
}
