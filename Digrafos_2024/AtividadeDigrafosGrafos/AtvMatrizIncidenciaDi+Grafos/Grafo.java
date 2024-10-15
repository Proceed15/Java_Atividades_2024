package Digrafos_2024.AtividadeDigrafosGrafos.AtvMatrizIncidencia;

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
            int origem = lerOrisDes("Digite o vértice de origem da aresta " + (i + 1), 1, numVertices);
            int destino = lerOrisDes("Digite o vértice de destino da aresta " + (i + 1), 1, numVertices);
            matrizIncidencia[origem - 1][i] = 1;
            matrizIncidencia[destino - 1][i] = 1;
        }
    }

    public void imprimirMatrizIncidencia() {
        StringBuilder MatrizDES = new StringBuilder("Matriz de Incidência:\n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numArestas; j++) {
                MatrizDES.append(matrizIncidencia[i][j]).append(" ");
            }
            MatrizDES.append("\n");
        }
        JOptionPane.showMessageDialog(null, MatrizDES.toString());
    }

    public void determinarGrau() {
        int vertice = lerOrisDes("Digite o vértice para calcular o grau", 1, numVertices);
        int grau = 0;
        for (int i = 0; i < numArestas; i++) {
            if (matrizIncidencia[vertice - 1][i] == 1) {
                grau++;
            }
        }
        JOptionPane.showMessageDialog(null, "O grau do vértice " + vertice + " é " + grau);
    }

    public void solicitarVerticeVizinho() {
        int vertice = lerOrisDes("Digite o vértice para saber os vertViz", 1, numVertices);
        StringBuilder vertViz = new StringBuilder();
        for (int i = 0; i < numArestas; i++) {
            if (matrizIncidencia[vertice - 1][i] == 1) {
                for (int j = 0; j < numVertices; j++) {
                    if (matrizIncidencia[j][i] == 1 && j != vertice - 1) {
                        vertViz.append(j + 1).append(" ");
                    }
                }
            }
        }
        String coordenadas = vertViz.length() > 0 ? vertViz.toString() : "Nenhum";
        JOptionPane.showMessageDialog(null, "Os vertViz do vértice " + vertice + " são: " + coordenadas);
    }

    public void informarArestasParalelasELacos() {
        int arestasParalelas = 0;
        int lacos = 0;
        StringBuilder coordenadas = new StringBuilder();
        for (int i = 0; i < numArestas; i++) {
            int contagem = 0;
            for (int j = 0; j < numVertices; j++) {
                if (matrizIncidencia[j][i] == 1) {
                    contagem++;
                }
            }
            if (contagem > 2) {
                arestasParalelas++;
                coordenadas.append("Aresta paralela ").append(i + 1).append("\n");
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
                    lacos++;
                    coordenadas.append("Laço no vértice ").append(origem).append("\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Arestas paralelas: " + arestasParalelas + "\nLaços: " + lacos + "\n" + coordenadas);
    }

    private int lerOrisDes(String coordenadas, int min, int max) {
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
