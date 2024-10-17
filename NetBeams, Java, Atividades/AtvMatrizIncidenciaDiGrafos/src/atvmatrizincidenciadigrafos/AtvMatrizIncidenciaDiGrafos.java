/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atvmatrizincidenciadigrafos;

import javax.swing.JOptionPane;
/**
 *
 * @author 0031432412016
 */
/**
 *
 * @author JRLSF
 */

/**
 *
 * @author 0031432412016
 */

import javax.swing.JOptionPane;

public class AtvMatrizIncidenciaDiGrafos {
    public static void main(String[] args) {
        //String[] options = {"Grafo", "Digrafo"};
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n"
                            + "1 - Acessar o Menu de Grafos\n"
                            + "2 - Acessar o Menu de Digrafos\n"
                            + "0 - Sair\n"
                            + "Informe a opção desejada:"));

        switch (op) {
                case 1:
                    Grafo();
                    break;
                case 2:
                    Digrafo();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (op != 0);
    }

    private static void Grafo() {
        int numVertices = NumRegistrador("Digite o número de vértices do grafo");
        int numArestas = NumRegistrador("Digite o número de arestas do grafo");

        Grafo grafo = new Grafo(numVertices, numArestas);
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n"
                            + "1 - Informe a Aresta\n"
                            + "2 - Imprima a Matriz de Incidencia\n"
                            + "3 - Determinar Grau dos Vertices\n"
                            + "4 - Determinar Vertices Vizinhos\n"
                            + "5 - Informar Arestas Paralelas E Lacos Existentes\n"
                            + "6 - Voltar\n"
                            + "0 - Sair\n"
                            + "Informe a opção desejada:"
            ));


            
            switch (op) {
                case 1:
                    grafo.informarArestas();
                    break;
                case 2:
                    grafo.imprimirMatrizIncidencia();
                    break;
                case 3:
                    grafo.determinarGrau();
                    break;
                case 4:
                    grafo.VerticesVizinhos();
                    break;
                case 5:
                    grafo.informarArestasParalelasELacos();
                    break;
                case 6:
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado.");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (op != 0 && op != 6);     
    }

    private static void Digrafo() {
        int numVertices = NumRegistrador("Digite o número de vértices do dígrafo");
        int numArestas = NumRegistrador("Digite o número de arestas do dígrafo");

        Digrafo digrafo = new Digrafo(numVertices, numArestas);
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n"
                            + "1 - Informe a Aresta\n"
                            + "2 - Imprima a Matriz de Incidencia\n"
                            + "3 - Determinar Grau de Entrada e de Saida dos Vertices\n"
                            + "4 - Determinar Vertices Vizinhos\n"
                            + "5 - Informar Arestas Paralelas E Lacos Existentes\n"
                            + "6 - Voltar\n"
                            + "0 - Sair\n"
                            + "Informe a opção desejada:"
            ));

            switch (op) {
                case 1:
                    digrafo.informarArestas();
                    break;
                case 2:
                    digrafo.imprimirMatrizIncidencia();
                    break;
                case 3:
                    digrafo.determinarGrauEntradaESaida();
                    break;
                case 4:
                    digrafo.VerticesVizinhos();
                    break;
                case 5:
                    digrafo.informarArestasParalelasELacos();
                    break;
                case 6:
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado.");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (op != 0 && op != 6);     
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
