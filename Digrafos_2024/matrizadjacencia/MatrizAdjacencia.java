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
        int qtdeVertices, qtdeAresta, op, /*vOrigem, vDestino,*/ vAresta;
        qtdeVertices=Integer.parseInt(JOptionPane.showInputDialog(
        "Informe a quantidade de vértices existentes no digrafo:"));
        qtdeAresta=Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de arestas existentes no digrafo"));
        Digrafo g = new Digrafo(qtdeVertices, qtdeAresta);
        do{
            op = Integer.parseInt(
                    JOptionPane.showInputDialog(
                      "1 - Definir Aresta de Origem e Destino do Vértice\n"
                    + "2 - Consultar número de arestas\n"
                    + "3 - Imprimir matriz de adjacência\n"
                    + "4 - Consultar grau de um Vértice\n"
                    + "5 - Grafo simples ou MultiGrafo\n"
                    + "6 - Vértices Vizinhos\n"
                    + "7 - Contar arestas paralelas e laços\n"
                    + "8 - Sair\n"
                    + "Informe a opção desejada:"));
            switch(op){
                /*
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
                */
                case 1:
                    for (int aresta = 0; aresta < qtdeAresta; aresta++) {
                    int vOrigem;
                    do {
                    vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de origem (valor entre 1 e " + qtdeVertices + "):"));
                    if (vOrigem < 1 || vOrigem > qtdeVertices) {
                        JOptionPane.showMessageDialog(null, "Valor inválido! Por favor, informe um valor entre 1 e " + qtdeVertices + ".");
                    }
                    } while (vOrigem < 1 || vOrigem > qtdeVertices);

                    int vDestino;
                    do {
                     vDestino = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de destino (valor entre 1 e " + qtdeVertices + "):"));
                    if (vDestino < 1 || vDestino > qtdeVertices) {
                        JOptionPane.showMessageDialog(null, "Valor inválido! Por favor, informe um valor entre 1 e " + qtdeVertices + ".");
                    }
                    } while (vDestino < 1 || vDestino > qtdeVertices);

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
                    int vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para consultar o grau de entrada e saída:"));
                    JOptionPane.showMessageDialog(null, "Grau de entrada: " + g.getGrauEntrada(vertice) + "\nGrau de saída: " + g.consultaGrau(vertice));
                    //g.consultaGrau(qtdeVertices);
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
                    int v = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para consultar os vértices vizinhos:"));
                    g.getVerticeVizinho(v);
                    //g.verticeVizinho();
                break;
                case 7:
                    g.contarArestasParalelasELacos();
                break;
                case 8:
                break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção inválida!");
                break;    
            }
        }while(op!=7);
        
        
    }
    
}
