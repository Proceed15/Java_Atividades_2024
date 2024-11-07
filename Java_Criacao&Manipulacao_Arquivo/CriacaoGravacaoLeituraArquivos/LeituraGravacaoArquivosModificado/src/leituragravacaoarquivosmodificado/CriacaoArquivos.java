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
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class CriacaoArquivos {
    FileWriter arq;
    PrintWriter gravarArq; 
    CriacaoArquivos(String nomeArq) throws IOException{
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
    void fechar() throws IOException{
        arq.close();
    }
}
