package Digrafos;
public class Main {
    public static void Main(String[] args) {
        Digrafos_Matriz_Adjacente graph = new Digrafos_Matriz_Adjacente(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0); // This edge makes it a graph

        graph.printGraph();
        graph.identifyGraph(); // Output: This is a Graph.

        Digrafos_Matriz_Adjacente digraph = new Digrafos_Matriz_Adjacente(4);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 3);

        digraph.printGraph();
        digraph.identifyGraph(); // Output: This is a Digraph.
    }
}
