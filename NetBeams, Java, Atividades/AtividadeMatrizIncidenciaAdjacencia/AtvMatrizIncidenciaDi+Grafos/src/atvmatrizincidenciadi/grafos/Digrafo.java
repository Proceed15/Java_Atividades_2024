/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atvmatrizincidenciadi.grafos;

/**
 *
 * @author 0031432412016
 */

import javax.swing.JOptionPane;

public class Digrafo {
    private int numVertices;
    private int numArestas;
    private int[][] matrizIncidencia;

    public Digrafo(int numVertices, int numArestas) {
        this.numVertices = numVertices;
        this.numArestas = numArestas;
        this.matrizIncidencia = new int[numVertices][numVertices];
    }

    public void informarArestas() {
        for (int i = 0; i < numArestas; i++) {
            int origem = GuardaOrisDes("Digite o vértice de origem da aresta " + (i + 1), 1, numVertices);
            int destino = GuardaOrisDes("Digite o vértice de destino da aresta " + (i + 1), 1, numVertices);
            matrizIncidencia[origem - 1][destino - 1] = 1;
        }
    }

    public void imprimirMatrizIncidencia() {
        StringBuilder MatrizDES = new StringBuilder("Matriz de Incidência:\n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                MatrizDES.append(matrizIncidencia[i][j]).append(" ");
            }
            MatrizDES.append("\n");
        }
        JOptionPane.showMessageDialog(null, MatrizDES.toString());
    }

    public void determinarGrauEntradaESaida() {
        int vertice = GuardaOrisDes("Digite o vértice para calcular o grau de entrada e saída", 1, numVertices);
        int grauEntrada = 0;
        int grauSaida = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizIncidencia[i][vertice - 1] == 1) {
                grauEntrada++;
            }
            if (matrizIncidencia[vertice - 1][i] == 1) {
                grauSaida++;
            }
        }
        JOptionPane.showMessageDialog(null, "O grau de entrada do vértice " + vertice + " é " + grauEntrada +
                "\nO grau de saída do vértice " + vertice + " é " + grauSaida);
    }

    public void VerticesVizinhos() {
        int vertice = GuardaOrisDes("Digite o vértice para saber os Vertices Vizinhos", 1, numVertices);
        StringBuilder vertViz = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            if (matrizIncidencia[vertice - 1][i] == 1) {
                vertViz.append(i + 1).append(" ");
            }
        }
        String coordenadas = vertViz.length() > 0 ? vertViz.toString() : "Nenhum";
        JOptionPane.showMessageDialog(null, "Os Vertices Vizinhos do vértice " + vertice + " são: " + coordenadas);
    }

    public void informarArestasParalelasELacos() {
        int arestasParalelas = 0;
        int lacos = 0;
        StringBuilder coordenadas = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (matrizIncidencia[i][j] == 1 && matrizIncidencia[j][i] == 1) {
                    arestasParalelas++;
                    coordenadas.append("Aresta paralela entre ").append(i + 1).append(" e ").append(j + 1).append("\n");
                }
            }
            if (matrizIncidencia[i][i] == 1) {
                lacos++;
                coordenadas.append("Laço no vértice ").append(i + 1).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Arestas paralelas: " + arestasParalelas + "\nLaços: " + lacos + "\n" + coordenadas);
    }

    private int GuardaOrisDes(String coordenadas, int min, int max) {
        while (true) {
            try {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(coordenadas));
                if (valor >= min && valor <= max) {
                    return valor;
                }
                JOptionPane.showMessageDialog(null, "Valor fora do intervalo permitido. Informe um valor entre " + min + " e " + max);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Por favor, informe um número inteiro.");
            }
        }
    }
}
