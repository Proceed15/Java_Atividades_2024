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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class leituraArquivos{
     private FileReader arq;
     private BufferedReader lerArq;
     leituraArquivos(File nomeArq) throws IOException{
        try {
            arq = new FileReader(nomeArq);
            lerArq = new BufferedReader(arq);
        } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo.\n",
          e.getMessage());
        }
     }
     String getLinha() throws IOException{
         return(lerArq.readLine());
     }
     void fechar()throws IOException{
         arq.close();
     } 
}
