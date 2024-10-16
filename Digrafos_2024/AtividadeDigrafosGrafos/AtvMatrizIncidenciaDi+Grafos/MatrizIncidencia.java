package Digrafos_2024.matrizincidencia;

import javax.swing.JOptionPane;

public class MatrizIncidencia {
    public static void main(String[] args) {
        String[] options = {"Grafo", "Digrafo"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de grafo", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (escolha == 0) {
            Grafo();
        } else {
            Digrafo();
        }
    }

    private static void Grafo() {
        int numVertices = NumRegistrador("Digite o número de vértices do grafo");
        int numArestas = NumRegistrador("Digite o número de arestas do grafo");

        Grafo grafo = new Grafo(numVertices, numArestas);
        grafo.informarArestas();
        grafo.imprimirMatrizIncidencia();
        grafo.determinarGrau();
        grafo.solicitarVerticeVizinho();
        grafo.informarArestasParalelasELacos();
    }

    private static void Digrafo() {
        int numVertices = NumRegistrador("Digite o número de vértices do dígrafo");
        int numArestas = NumRegistrador("Digite o número de arestas do dígrafo");

        Digrafo digrafo = new Digrafo(numVertices, numArestas);
        digrafo.informarArestas();
        digrafo.imprimirMatrizIncidencia();
        digrafo.determinarGrauEntradaESaida();
        digrafo.VerticesVizinhos();
        digrafo.informarArestasParalelasELacos();
    }

    private static int NumRegistrador(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Por favor, informe um valor inteiro.");
            }
        }
    }
}
