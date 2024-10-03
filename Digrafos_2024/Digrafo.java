/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Digrafos_2024;

import javax.swing.JOptionPane;

/**
 *
 * @author josé
 */
public class Digrafo {
    int numAresParl;
    private int[][] matrizAdj;
    private int numVertices;
    private int numArestas;
    
    public Digrafo(int nVertices){
        matrizAdj = new int[nVertices][nVertices];
        numVertices = nVertices;
        numArestas = 0;
        //Inicializando a matriz com o número zero 
        for(int linha=0; linha<nVertices; linha++){
            for(int coluna=0; coluna<nVertices; coluna++){
                matrizAdj[linha][coluna]=0;
            }
        }
    }
    public void adicionarAresta(int origem, int destino){
        matrizAdj[origem-1][destino-1]+=1;
        //Para Digrafos é uma origem e destino para cada aresta
        //matrizAdj[destino-1][origem-1]+=1;
        this.numArestas++;
    }
    public int consultaGrau(int vertice){
        int grau=0;
        for(int coluna=0; coluna<this.numVertices; coluna++){
            grau+=matrizAdj[vertice-1][coluna];
            //fazer dois consultar um para grau de entrada e e outro para saída
        }
        return grau;
    }
    public int getNumArestas(){
        return this.numArestas;
    }
    public void imprimirDigrafo(){
        String representacao="";
        for(int linha=0; linha<this.numVertices;linha++){
            for(int coluna=0; coluna<this.numVertices; coluna++){
                representacao+=matrizAdj[linha][coluna] + " ";
            }
            representacao+="\n";
        }
        JOptionPane.showMessageDialog(null,
                "Matriz de Adjacência\n" + representacao);
    }
    public boolean DigrafoSimples(){
        int loop=0, arestaParalela=0;
        for(int linha=0; linha<this.numVertices;linha++){
            for(int coluna=0; coluna<this.numVertices; coluna++){
                if(linha==coluna && matrizAdj[linha][coluna]==1){
                    loop+=1;
                }
                if(matrizAdj[linha][coluna]==2){
                    arestaParalela+=1;
                }
            }
            int numAresParl = arestaParalela;
         }
        if(loop!=0 || arestaParalela!=0){
            return false;
        }
        else{
            return true;
        }
        
    }
}
