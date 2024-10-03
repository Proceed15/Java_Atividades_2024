/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Digrafos_2024.matrizadjacencia;

import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class MatrizAdjacencia {

    public static void main(String[] args) {
        int qtdeVertices, qtdeAresta, op, vOrigem, vDestino, vAresta;
        qtdeVertices=Integer.parseInt(JOptionPane.showInputDialog(
        "Informe a quantidade de vértices existentes no digrafo:"));
        qtdeAresta=Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de arestas existentes no digrafo"));
        Grafo g = new Grafo(qtdeVertices, qtdeAresta);
        do{
            op = Integer.parseInt(
                    JOptionPane.showInputDialog(
                      " 1 - Definir Aresta Origem do vertice e Destino\n"
                    + "2 - Consultar número de arestas\n"
                    + "3 - Imprimir matriz de adjacência\n"
                    + "4 - Consultar grau de um vértice\n"
                    + "5 - Grafo simples ou MultiGrafo\n"
                    + "6 - Vértices vizinhos\n"
                    + "7 - Sair\n"
                    + "Informe a opção desejada:"));
            switch(op){
                case 1:
                    
                    for(int aresta=0; aresta<qtdeAresta; aresta++){
                    vOrigem=Integer.parseInt(
                           JOptionPane.showInputDialog(
                            "Informe o vértice de origem (valor maior que 0):"));
                    vDestino=Integer.parseInt(
                           JOptionPane.showInputDialog(
                            "Informe o vértice de destino(valor maior que 0):"));
               
                    g.relacionarAresta(vOrigem, vDestino);
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, 
                            "O grafo possui " + g.getNumArestas() + "arestas.");
                    break;
                case 3:
                    g.imprimirGrafo();
                    break;
                case 4:
                    g.consultaGrau(qtdeVertices);
                    break;
                case 5:
                    if(g.grafoSimples()){
                        JOptionPane.showMessageDialog(null, 
                                "O grafo é simples (sem laços ou arestas paralelas)");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                "O grafo é multigrafo (tem laços e/ou arestas paralelas)");
                    }
                    break;
                case 6:
                    g.verticeVizinho();
                    break;
                case 7:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção inválida!");
                    break;    
            }
        }while(op!=7);
        
        
    }
    
}
