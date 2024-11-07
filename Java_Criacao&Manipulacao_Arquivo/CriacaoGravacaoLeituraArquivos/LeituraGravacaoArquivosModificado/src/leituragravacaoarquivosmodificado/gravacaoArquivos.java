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
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;

public class gravacaoArquivos {
    private FileWriter arq;
    private BufferedWriter writer;
    //private PrintWriter gravarArq;
   
    gravacaoArquivos(File nomeArq)throws IOException{
        try {
            //arq = new FileWriter(nomeArq);
            //gravarArq = new PrintWriter(arq);
            arq = new FileWriter(nomeArq);
            writer = new BufferedWriter(arq);
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo.\n",
          e.getMessage());
        }
    }
    void escreveLinha(String texto)throws IOException{
        //gravarArq.print(texto);
        writer.write(texto);
        writer.flush();
    }
    void fechar()throws IOException{
        arq.close();
    }
    
    
}
