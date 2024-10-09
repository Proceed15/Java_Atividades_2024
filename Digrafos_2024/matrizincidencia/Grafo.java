package Digrafos_2024.matrizincidencia;

import javax.swing.JOptionPane;

public class Grafo {
    private int numVertices;
    private int numArestas;
    private int[][] matrizIncidencia;

    public Grafo(int numVertices, int numArestas) {
        this.numVertices = numVertices;
        this.numArestas = numArestas;
        this.matrizIncidencia = new int[numVertices][numArestas];
    }

    public void informarArestas() {
        for (int i = 0; i < numArestas; i++) {
            int origem = Integer.parseInt(JOptionPane.showInputDialog("Digite o vértice de origem da aresta " + (i + 1)));
            int destino = Integer.parseInt(JOptionPane.showInputDialog("Digite o vértice de destino da aresta " + (i + 1)));
            matrizIncidencia[origem - 1][i] = 1;
            matrizIncidencia[destino - 1][i] = 1;
        }
    }

    public void imprimirMatrizIncidencia() {
        String representacao = "";
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numArestas; j++) {
                representacao += matrizIncidencia[i][j] + " ";
            }
            representacao += "\n";
        }
        JOptionPane.showMessageDialog(null, "Matriz de Incidência\n" + representacao);
    }

    public void determinarGrau() {
        int grau = 0;
        int vertice = Integer.parseInt(JOptionPane.showInputDialog("Digite o vértice para calcular o grau"));
        for (int i = 0; i < numArestas; i++) {
            if (matrizIncidencia[vertice - 1][i] == 1) {
                grau++;
            }
        }
        JOptionPane.showMessageDialog(null, "O grau do vértice " + vertice + " é " + grau);
    }

    public void solicitarVerticeVizinho() {
        int vertice = Integer.parseInt(JOptionPane.showInputDialog("Digite o vértice para saber os vizinhos"));
        String vizinhos = "";
        for (int i = 0; i < numArestas; i++) {
            if (matrizIncidencia[vertice - 1][i] == 1) {
                for (int j = 0; j < numVertices; j++) {
                    if (matrizIncidencia[j][i] == 1 && j != vertice - 1) {
                        vizinhos += (j + 1) + " ";
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Os vizinhos do vértice " + vertice + " são " + vizinhos);
    }

    public void informarArestasParalelasELacos() {
        int arestasParalelas = 0;
        int laços = 0;
        String mensagem = "";
        for (int i = 0; i < numArestas; i++) {
            int contagem = 0;
            for (int j = 0; j < numVertices; j++) {
                if (matrizIncidencia[j][i] == 1) {
                    contagem++;
                }
            }
            if (contagem > 2) {
                arestasParalelas++;
                mensagem += "Aresta paralela " + (i + 1) + "\n";
            } else if (contagem == 2) {
                int origem = 0;
                int destino = 0;
                for (int j = 0; j < numVertices; j++) {
                    if (matrizIncidencia[j][i] == 1) {
                        if (origem == 0) {
                            origem = j + 1;
                        } else {
                            destino = j + 1;
                        }
                    }
                }
                if (origem == destino) {
                    laços++;
                    mensagem += "Laço no vértice " + origem + "\n";
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Arestas paralelas: " + arestasParalelas + "\nLaços: " + laços + "\n" + mensagem);
    }
}
