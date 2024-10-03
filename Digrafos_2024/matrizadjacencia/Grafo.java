/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Digrafos_2024.matrizadjacencia;

import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class Grafo {
    private int[][] matrizAdj;
    private int numVertices;
    private int numArestas;
    
    public Grafo(int nVertices, int nAresta){
        matrizAdj = new int[nVertices][nVertices];
        numVertices = nVertices;
        numArestas = nAresta;
        //Inicializando a matriz com o número zero 
        for(int linha=0; linha<nVertices; linha++){
            for(int coluna=0; coluna<nVertices; coluna++){
                matrizAdj[linha][coluna]=0;
            }
        }
    }
    public void relacionarAresta(int origem, int destino){
        matrizAdj[origem-1][destino-1]+=1;
    }
    public int consultaGrau(int vertice){
        int grau=0;
        for(int coluna=0; coluna<this.numVertices; coluna++){
            grau+=matrizAdj[vertice-1][coluna];
        }
        return grau;
    }
    public int getNumArestas(){
        return this.numArestas;
    }
    public void imprimirGrafo(){
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
    public boolean grafoSimples(){
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
         }
        if(loop!=0 || arestaParalela!=0){
            return false;
        }
        else{
            return true;
        }
        
    }
    
    public void verticeVizinho() {
        StringBuilder mensagem = new StringBuilder(); 

        for (int i = 0; i < matrizAdj.length; i++) { 
            StringBuilder linhaMensagem = new StringBuilder(); 
            linhaMensagem.append("Linha ").append(i + 1).append("- ");

            boolean encontrouValor = false;

            for (int j = 0; j < matrizAdj[i].length; j++) { 
                int valor = matrizAdj[i][j];
                if (valor > 0) { 
                    if (encontrouValor) {
                        linhaMensagem.append(" ");
                    }
                    linhaMensagem.append("Coluna ").append(j + 1).append(": ").append(valor);
                    encontrouValor = true; 
                }
            }

            
            if (encontrouValor) {
                mensagem.append(linhaMensagem).append("\n");
            }
        }

        
        if (mensagem.length() > 0) { 
            JOptionPane.showMessageDialog(null, mensagem.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum valor maior que 0 encontrado.");
        }
    }
}
