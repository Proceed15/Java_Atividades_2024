package Digrafos;

public class Digrafos_Matriz {
    // Identificar Digrafos e Grafos
    private int numVertices;
    private int[][] adjacencyMatrix;

    public static void Main(String[] args) throws Exception{
        Digrafos_Matriz graph = new Digrafos_Matriz(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0); // Essa aresta faz dele um grafo

        graph.printGraph();
        graph.identifyGraph(); // Saída: Este é um Grafo.

        Digrafos_Matriz digraph = new Digrafos_Matriz(4);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 3);

        digraph.printGraph();
        digraph.identifyGraph(); // Saída: Este é um Digrafo.
    }

    public Digrafos_Matriz(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = 1;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isDirected() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1 && adjacencyMatrix[j][i] == 0) {
                    return true; // Digrafo
                }
            }
        }
        return false; // Grafo
    }

    public void identifyGraph() {
        if (isDirected()) {
            System.out.println("Este é um Digrafo.");
        } else {
            System.out.println("Este é um Grafo.");
        }
    }
}
