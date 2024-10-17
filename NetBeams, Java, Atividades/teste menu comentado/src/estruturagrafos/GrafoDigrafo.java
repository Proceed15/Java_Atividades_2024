package estruturagrafos;

import javax.swing.JOptionPane;

public class GrafoDigrafo {
    private int[][] matrizIncidencia; // Matriz de incidência que representa as arestas do grafo
    private int numVertices; // Número de vértices no grafo
    private int numArestas; // Número de arestas no grafo
    private boolean isDigrafo; // Indica se o grafo é direcionado ou não

    // Construtor da classe, inicializa a matriz de incidência e os parâmetros
    public GrafoDigrafo(int numVertices, boolean isDigrafo) {
        this.numVertices = numVertices; // Define o número de vértices
        this.isDigrafo = isDigrafo; // Define se o grafo é direcionado
        this.matrizIncidencia = new int[numVertices][numVertices]; // Cria a matriz de incidência
        this.numArestas = 0; // Inicializa o número de arestas
    }

    // Método para adicionar arestas entre os vértices
    public void adicionarAresta(int origem, int destino) {
        // Verifica se os vértices informados são válidos
        if (origem < 1 || origem > numVertices || destino < 1 || destino > numVertices) {
            JOptionPane.showMessageDialog(null, "Vértice inválido!");
            return; // Sai do método se os vértices forem inválidos
        }

        matrizIncidencia[origem - 1][destino - 1] += 1; // Adiciona aresta na matriz (direcionada)
        if (!isDigrafo) {
            matrizIncidencia[destino - 1][origem - 1] += 1; // Adiciona aresta na matriz (não direcionada)
        }
        numArestas++; // Incrementa o número de arestas
    }

    // Método para imprimir a matriz de incidência
    public void imprimirMatrizIncidencia() {
        StringBuilder sb = new StringBuilder("Matriz de Incidência:\n"); // StringBuilder para construir a string da matriz
        for (int i = 0; i < numVertices; i++) { // Percorre as linhas da matriz
            for (int j = 0; j < numVertices; j++) { // Percorre as colunas da matriz
                sb.append(matrizIncidencia[i][j]).append(" "); // Adiciona cada elemento à string
            }
            sb.append("\n"); // Nova linha após cada linha da matriz
        }
        JOptionPane.showMessageDialog(null, sb.toString()); // Mostra a matriz em uma caixa de diálogo
    }

    // Método para verificar se o grafo é simples (sem laços e arestas paralelas)
    public boolean grafoSimples() {
        for (int i = 0; i < numVertices; i++) { // Percorre os vértices
            if (matrizIncidencia[i][i] > 0) {
                return false; // Retorna falso se encontrar um laço
            }
            for (int j = 0; j < numVertices; j++) {
                if (matrizIncidencia[i][j] > 1) {
                    return false; // Retorna falso se encontrar arestas paralelas
                }
            }
        }
        return true; // Se não encontrar laços ou arestas paralelas, o grafo é simples
    }

    // Método para calcular o grau de um vértice
    public int calcularGrau(int vertice) {
        // Verifica se o vértice informado é válido
        if (vertice < 1 || vertice > numVertices) {
            JOptionPane.showMessageDialog(null, "Vértice inválido!");
            return -1; // Retorna -1 para indicar erro
        }
        
        int grau = 0; // Inicializa o grau
        for (int j = 0; j < numVertices; j++) { // Percorre os vértices
            grau += matrizIncidencia[vertice - 1][j]; // Soma as arestas que saem do vértice
            if (!isDigrafo) {
                grau += matrizIncidencia[j][vertice - 1]; // Soma as arestas que entram no vértice (se não for dígrafo)
            }
        }
        return grau; // Retorna o grau do vértice
    }

    // Método para listar vizinhos de um vértice
    public String listarVizinhos(int vertice) {
        // Verifica se o vértice informado é válido
        if (vertice < 1 || vertice > numVertices) {
            return "Vértice inválido!"; // Retorna mensagem de erro se inválido
        }

        StringBuilder sb = new StringBuilder("Vizinhos do vértice " + vertice + ": "); // Inicializa a string de vizinhos
        for (int j = 0; j < numVertices; j++) { // Percorre os vértices
            if (matrizIncidencia[vertice - 1][j] > 0) {
                sb.append(j + 1).append(" "); // Adiciona o vizinho à string (ajusta índice)
            }
        }
        return sb.toString(); // Retorna a lista de vizinhos
    }

    // Método para informar sobre laços e arestas paralelas
    public String identificarArestasParalelasELaços() {
        StringBuilder sb = new StringBuilder(); // Inicializa StringBuilder para construir a mensagem
        boolean temLaços = false; // Flag para verificar se existem laços
        boolean temArestasParalelas = false; // Flag para verificar se existem arestas paralelas

        for (int i = 0; i < numVertices; i++) { // Percorre os vértices
            if (matrizIncidencia[i][i] > 0) {
                temLaços = true; // Encontra um laço
                sb.append("Laço encontrado no vértice ").append(i + 1).append("\n"); // Adiciona mensagem sobre o laço
            }
            for (int j = 0; j < numVertices; j++) {
                if (matrizIncidencia[i][j] > 1) {
                    temArestasParalelas = true; // Encontra arestas paralelas
                    sb.append("Arestas paralelas entre os vértices ").append(i + 1).append(" e ").append(j + 1).append("\n"); // Adiciona mensagem sobre arestas paralelas
                }
            }
        }

        if (!temLaços && !temArestasParalelas) {
            sb.append("O grafo não possui laços ou arestas paralelas."); // Mensagem se não encontrar laços ou arestas paralelas
        }
        return sb.toString(); // Retorna a mensagem construída
    }

    // Métodos para obter o número de vértices e arestas
    public int getNumVertices() {
        return numVertices; // Retorna o número de vértices
    }

    public int getNumArestas() {
        return numArestas; // Retorna o número de arestas
    }
}
