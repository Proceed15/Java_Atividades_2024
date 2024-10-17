package estruturagrafos;

// Importa a classe JOptionPane para exibir diálogos na interface gráfica.
import javax.swing.JOptionPane;

public class DigrafoAdj {
    // Matriz de adjacência que armazena a relação entre os vértices
    private int[][] matrizAdj;
    // Número de vértices no dígrafo
    private int numVertices;
    // Número de arestas no dígrafo
    private int numArestas;

    // Construtor da classe que inicializa o dígrafo com um número específico de vértices
    public DigrafoAdj(int nVertices) {
        // Atribui o número de vértices
        this.numVertices = nVertices;
        // Inicializa a matriz de adjacência com um tamanho nVertices x nVertices
        this.matrizAdj = new int[nVertices][nVertices];
        // Inicializa o contador de arestas como 0
        this.numArestas = 0;

        // Inicializa a matriz de adjacência com 0
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                this.matrizAdj[i][j] = 0; // A matriz começa sem arestas
            }
        }
    }

    // Método para adicionar uma aresta entre dois vértices (origem e destino)
    public void adicionarAresta(int origem, int destino) {
        // Incrementa o contador da aresta entre os vértices de origem e destino
        matrizAdj[origem - 1][destino - 1]++;
        // Incrementa o número total de arestas
        numArestas++;
    }

    // Método para obter o número total de arestas no dígrafo
    public int getNumArestas() {
        return this.numArestas;
    }

    // Método para imprimir a matriz de adjacência em um diálogo
    public void imprimirMatrizAdjacencia() {
        StringBuilder sb = new StringBuilder("Matriz de Adjacência:\n");
        // Percorre a matriz e a adiciona ao StringBuilder
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(matrizAdj[i][j]).append(" "); // Adiciona o valor da matriz
            }
            sb.append("\n"); // Adiciona nova linha após cada linha da matriz
        }
        // Exibe a matriz em um diálogo
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Método para calcular o grau de entrada de um vértice
    public int grauEntrada(int vertice) {
        int grauEntrada = 0; // Inicializa o grau de entrada como 0
        // Soma todas as arestas que chegam ao vértice especificado
        for (int i = 0; i < numVertices; i++) {
            grauEntrada += matrizAdj[i][vertice - 1]; // Soma os valores correspondentes
        }
        return grauEntrada; // Retorna o grau de entrada calculado
    }

    // Método para calcular o grau de saída de um vértice
    public int grauSaida(int vertice) {
        int grauSaida = 0; // Inicializa o grau de saída como 0
        // Soma todas as arestas que saem do vértice especificado
        for (int j = 0; j < numVertices; j++) {
            grauSaida += matrizAdj[vertice - 1][j]; // Soma os valores correspondentes
        }
        return grauSaida; // Retorna o grau de saída calculado
    }

    // Método para verificar se o dígrafo é simples (sem laços e arestas paralelas)
    public boolean digrafoSimples() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                // Verifica se há laços (aresta que liga um vértice a ele mesmo) ou arestas paralelas
                if ((i == j && matrizAdj[i][i] > 0) || matrizAdj[i][j] > 1) {
                    return false; // Retorna falso se encontrar laços ou arestas paralelas
                }
            }
        }
        return true; // Retorna verdadeiro se for um dígrafo simples
    }

    // Método para encontrar os vizinhos de um vértice
    public String vizinhos(int vertice) {
        StringBuilder sb = new StringBuilder();
        // Percorre todos os vértices para encontrar os vizinhos do vértice especificado
        for (int j = 0; j < numVertices; j++) {
            if (matrizAdj[vertice - 1][j] > 0) {
                sb.append(j + 1).append(" "); // Adiciona vizinhos ao StringBuilder
            }
        }
        return sb.toString(); // Retorna a lista de vizinhos
    }

    // Método para informar sobre laços e arestas paralelas
    public String informarArestasParalelasELaços() {
        int loops = 0, arestasParalelas = 0; // Contadores para laços e arestas paralelas
        StringBuilder sb = new StringBuilder("Arestas paralelas e laços:\n");

        // Verifica laços e arestas paralelas
        for (int i = 0; i < numVertices; i++) {
            // Verifica se há laços no vértice
            if (matrizAdj[i][i] > 0) {
                loops++;
                sb.append("Loop no vértice ").append(i + 1).append(" (").append(matrizAdj[i][i]).append(")\n");
            }
            // Verifica arestas paralelas
            for (int j = 0; j < numVertices; j++) {
                if (i != j && matrizAdj[i][j] > 1) {
                    arestasParalelas++;
                    sb.append("Aresta paralela entre vértices ").append(i + 1).append(" e ").append(j + 1).append(" (").append(matrizAdj[i][j]).append(")\n");
                }
            }
        }

        // Adiciona totais ao StringBuilder
        sb.append("Total de laços: ").append(loops).append("\n");
        sb.append("Total de arestas paralelas: ").append(arestasParalelas).append("\n");

        return sb.toString(); // Retorna informações sobre laços e arestas paralelas
    }

    // Método para informar o número de vértices e arestas
    public String informarNumVerticesEArestas() {
        return "Número de vértices: " + numVertices + "\nNúmero de arestas: " + numArestas; // Retorna contagem de vértices e arestas
    }
}
