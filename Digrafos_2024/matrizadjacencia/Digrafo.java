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
public class Digrafo {
    private int[][] matrizAdj;
    private int numVertices;
    private int numArestas;
    
    public Digrafo(int nVertices, int nAresta){
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
    public int getGrauEntrada(int vertice) {
        int grau = 0;
        for (int linha = 0; linha < this.numVertices; linha++) {
            grau += matrizAdj[linha][vertice - 1];
        }
        return grau;
    }
    
    public void getVerticeVizinho(int vertice) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Vértices vizinhos de ").append(vertice).append(":\n");
        for (int coluna = 0; coluna < this.numVertices; coluna++) {
            if (matrizAdj[vertice - 1][coluna] > 0) {
                mensagem.append(coluna + 1).append(" ");
            }
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
    
    public void contarArestasParalelasELacos() {
        int arestasParalelas = 0;
        int laços = 0;
        StringBuilder mensagem = new StringBuilder();
        for (int linha = 0; linha < this.numVertices; linha++) {
            for (int coluna = 0; coluna < this.numVertices; coluna++) {
                if (linha == coluna && matrizAdj[linha][coluna] > 0) {
                    laços++;
                    mensagem.append("Laço em ").append(linha + 1).append("\n");
                } else if (matrizAdj[linha][coluna] > 1) {
                    arestasParalelas++;
                    mensagem.append("Aresta paralela entre ").append(linha + 1).append(" e ").append(coluna + 1).append("\n");
                }
            }
        }
        mensagem.insert(0, "Arestas paralelas: ").append(arestasParalelas).append("\nLaços: ").append(laços).append("\n");
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
    public void relacionarAresta(int origem, int destino){
        matrizAdj[origem-1][destino-1]+=1;
        //Para Digrafos é uma origem e destino para cada aresta
        //matrizAdj[destino-1][origem-1]+=1;
        //this.nAresta++;
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
