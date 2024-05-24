/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2listaencadeada;

import javax.swing.JOptionPane;
/**
 *
 * @author 0031432412016
 */
public class Exercicio2ListaEncadeada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEncadeada lista = new ListaEncadeada();
        int numElem;
        JOptionPane.showMessageDialog(null, "Colhe Pares");
        numElem=Integer.parseInt(JOptionPane.showInputDialog("Informe o número "+
            " de elementos a serem inseridos na lista: "));
        for(int i=0; i<numElem; i++){
            int valor = Integer.parseInt(JOptionPane.showInputDialog(
                    "Informe o valor a ser inserido na lista:"));
            //lista.insereNo_inicio(new IntNoSimples(valor));
            if(valor==0){
                break;
            }
            else if (valor%2==0){
                lista.insereNo_inicio(new IntNoSimples(valor));
            }
        }
        lista.ExibeLista();
    }  
}