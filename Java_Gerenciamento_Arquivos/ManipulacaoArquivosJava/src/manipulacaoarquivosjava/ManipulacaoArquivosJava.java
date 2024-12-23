/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manipulacaoarquivosjava;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ManipulacaoArquivosJava {

  public static void main(String[] args) throws IOException {
    Scanner ler = new Scanner(System.in);
    int i, n;

    System.out.printf("Informe o número para a tabuada:\n");
    n = ler.nextInt();

    FileWriter arq = new FileWriter("C:\\Users\\0031432412016\\desktop\\tabuada.txt");
    PrintWriter gravarArq = new PrintWriter(arq);

    gravarArq.printf("+--Resultado--+%n");
    for (i=1; i<=10; i++) {
      gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n));
    }
    gravarArq.printf("+-------------+%n");

    arq.close();

    System.out.printf("\nTabuada do %d foi gravada com sucesso em \"C:\\\\Users\\\\0031432412016\\\\desktop\\\\tabuada.txt\"\n", n);
  }

}
   
