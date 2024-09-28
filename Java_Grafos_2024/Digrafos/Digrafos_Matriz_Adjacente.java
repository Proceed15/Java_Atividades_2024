package Digrafos;
public class Digrafos_Matriz_Adjacente {
    //Identificar Digrafos e Grafos
    private int numVertices;
    private int[][] adjacencyMatrix;

    public Digrafos_Matriz_Adjacente(int numVertices) {
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
                    return true; // Digraph
                }
            }
        }
        return false; // Graph
    }

    public void identifyGraph() {
        if (isDirected()) {
            System.out.println("This is a Digraph.");
        } else {
            System.out.println("This is a Graph.");
        }
    }
}