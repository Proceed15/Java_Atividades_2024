package estruturagrafos;

// Importa a classe JOptionPane para exibir diálogos na interface gráfica.
import javax.swing.JOptionPane;

public class DigrafoInc {
    // Matriz de incidência que armazena a relação entre vértices e arestas
    private int[][] matrizInc;
    // Número de vértices no dígrafo
    private int numVertices;
    // Número de arestas no dígrafo
    private int numArestas;

    // Construtor da classe que inicializa o dígrafo com um número específico de vértices
    public DigrafoInc(int nVertices) {
        // Inicializa a matriz de incidência com tamanho nVertices x nVertices
        matrizInc = new int[nVertices][nVertices];
        // Atribui o número de vértices
        numVertices = nVertices;
        // Inicializa o contador de arestas como 0
        numArestas = 0;

        // Inicializando a matriz com zeros
        for (int linha = 0; linha < nVertices; linha++) {
            for (int coluna = 0; coluna < nVertices; coluna++) {
                matrizInc[linha][coluna] = 0; // A matriz começa sem arestas
            }
        }
    }

    // Método para adicionar arestas
    public void adicionarAresta(int origem, int destino) {
        // Incrementa o valor na matriz de incidência, representando a adição de uma aresta
        matrizInc[origem - 1][destino - 1] += 1;
        // Incrementa o número total de arestas
        this.numArestas++;
    }

    // Métodos para calcular graus
    // Calcula o grau de entrada de um vértice
    public int grauEntrada(int vertice) {
        int grauEntrada = 0; // Inicializa o grau de entrada como 0
        // Soma todas as arestas que chegam ao vértice especificado
        for (int i = 0; i < numVertices; i++) {
            grauEntrada += matrizInc[i][vertice - 1]; // Soma os valores correspondentes
        }
        return grauEntrada; // Retorna o grau de entrada calculado
    }

    // Calcula o grau de saída de um vértice
    public int grauSaida(int vertice) {
        int grauSaida = 0; // Inicializa o grau de saída como 0
        // Soma todas as arestas que saem do vértice especificado
        for (int j = 0; j < numVertices; j++) {
            grauSaida += matrizInc[vertice - 1][j]; // Soma os valores correspondentes
        }
        return grauSaida; // Retorna o grau de saída calculado
    }

    // Método para imprimir a matriz de incidência
    public void imprimirGrafo() {
        StringBuilder representacao = new StringBuilder(); // StringBuilder para formatar a saída
        // Percorre a matriz e a adiciona ao StringBuilder
        for (int linha = 0; linha < numVertices; linha++) {
            for (int coluna = 0; coluna < numVertices; coluna++) {
                representacao.append(matrizInc[linha][coluna]).append(" "); // Adiciona o valor da matriz
            }
            representacao.append("\n"); // Adiciona nova linha após cada linha da matriz
        }
        // Exibe a matriz em um diálogo
        JOptionPane.showMessageDialog(null, "Matriz de Incidência:\n" + representacao);
    }

    // Verifica se o grafo é simples
    public boolean grafoSimples() {
        for (int linha = 0; linha < numVertices; linha++) {
            if (matrizInc[linha][linha] > 0) return false; // Laço encontrado
            for (int coluna = 0; coluna < numVertices; coluna++) {
                if (matrizInc[linha][coluna] > 1) return false; // Aresta paralela encontrada
            }
        }
        return true; // Grafo é simples se não encontrou laços ou arestas paralelas
    }

    // Identifica laços e arestas paralelas
    public String informeMultigrafo() {
        StringBuilder sb = new StringBuilder("Arestas paralelas e laços:\n");
        int loops = 0, arestaParalelas = 0; // Contadores para laços e arestas paralelas

        // Verifica laços e arestas paralelas na matriz de incidência
        for (int i = 0; i < numVertices; i++) {
            if (matrizInc[i][i] > 0) {
                loops++; // Conta laços
                sb.append("Loop no vértice ").append(i + 1).append(" (").append(matrizInc[i][i]).append(")\n");
            }
            for (int j = 0; j < numVertices; j++) {
                if (matrizInc[i][j] > 1) {
                    arestaParalelas++; // Conta arestas paralelas
                    sb.append("Aresta paralela entre vértices ").append(i + 1).append(" e ").append(j + 1).append(" (").append(matrizInc[i][j]).append(")\n");
                }
            }
        }
        // Adiciona totais ao StringBuilder
        sb.append("Total de laços: ").append(loops).append("\n");
        sb.append("Total de arestas paralelas: ").append(arestaParalelas).append("\n");

        return sb.toString(); // Retorna informações sobre laços e arestas paralelas
    }

    // Lista vizinhos de um vértice
    public String vizinhos(int vertice) {
        StringBuilder sb = new StringBuilder("Vizinhos do vértice " + vertice + ": ");
        // Percorre todos os vértices para encontrar os vizinhos do vértice especificado
        for (int j = 0; j < numVertices; j++) {
            if (matrizInc[vertice - 1][j] > 0) {
                sb.append(j + 1).append(" "); // Adiciona vizinhos ao StringBuilder
            }
        }
        return sb.toString(); // Retorna a lista de vizinhos
    }

    // Métodos para obter o número de arestas e vértices
    public int getNumArestas() {
        return this.numArestas; // Retorna o número total de arestas
    }

    public int getNumVertices() {
        return this.numVertices; // Retorna o número total de vértices
    }
}
