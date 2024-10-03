/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrizadjacencia;

import javax.swing.JOptionPane;

/**
 *
 * @author José
 */
public class MatrizAdjacencia {

    public static void main(String[] args) {
        int qtdeVertices, op, vOrigem, vDestino, vertice;
        qtdeVertices=Integer.parseInt(JOptionPane.showInputDialog(
        "Informe a quantidade de vértices existentes no grafo:"));
        Grafo g = new Grafo(qtdeVertices);
        do{
            op = Integer.parseInt(
                    JOptionPane.showInputDialog(
                      "1 - Adicionar aresta\n"
                    + "2 - Consultar número de arestas\n"
                    + "3 - Imprimir matriz de adjacência\n"
                    + "4 - Consultar grau de um vértice\n"
                    + "5 - Grafo simples ou MultiGrafo\n"
                    + "6 - Sair\n"
                    + "Informe a opção desejada:"));
            switch(op){
                case 1:
                    vOrigem=Integer.parseInt(
                           JOptionPane.showInputDialog(
                            "Informe o vértice de origem (valor maior que 0):"));
                    vDestino=Integer.parseInt(
                           JOptionPane.showInputDialog(
                            "Informe o vértice de destino(valor maior que 0):"));
                    g.adicionarAresta(vOrigem, vDestino);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, 
                            "O grafo possui " + g.getNumArestas() + "arestas.");
                    break;
                case 3:
                    g.imprimirGrafo();
                    break;
                case 4:
                    vertice=Integer.parseInt(
                           JOptionPane.showInputDialog(
                            "Informe o vértice para consultar o grau:"));
                    JOptionPane.showMessageDialog(
                            null, 
                            "O grau do vértice informado é:" + 
                                    g.consultaGrau(vertice));
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
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção inválida!");
                    break;    
            }
        }while(op!=5);
        
        
    }
    
}
