package estruturagrafos;

import javax.swing.JOptionPane;

public class EstruturaGrafos {
    public static void main(String[] args) {
        int nVertices, op, vOrigem, vDestino, vertice, menu;

        // Solicita ao usuário que escolha o tipo de grafo a trabalhar
        menu = Integer.parseInt(JOptionPane.showInputDialog(
            "Deseja trabalhar com:\n" +
            "1 - Matriz de Incidência (Dígrafo)\n" +
            "2 - Matriz de Adjacência (Dígrafo)\n" +
            "3 - Matriz de grafo (Grafo)"
        ));

        if (menu == 1) { // Trabalhando com dígrafos usando matriz de incidência
            nVertices = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vértices no dígrafo:"));
            DigrafoInc digrafo = new DigrafoInc(nVertices); // Criação do objeto DigrafoInc

            do {
                // Menu de operações para o dígrafo
                op = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Adicionar aresta\n" +
                    "2 - Imprimir matriz de incidência\n" +
                    "3 - Consultar a entrada e a saida\n" +
                    "4 - Consultar o grau do grafo\n" +
                    "5 - Verificar se o dígrafo é simples ou multigrafo\n" +
                    "6 - Consultar vértices vizinhos\n" +
                    "7 - Consultar laços e arestas paralelas\n" +
                    "8 - Informar número de vértices e arestas\n" +
                    "0 - Sair\n" +
                    "Informe a opção desejada:"
                ));

                switch (op) {
                    case 1: // Adicionar aresta
                        vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de origem:"));
                        vDestino = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de destino:"));
                        digrafo.adicionarAresta(vOrigem, vDestino); // Chama o método para adicionar a aresta
                        JOptionPane.showMessageDialog(null, "Aresta adicionada de " + vOrigem + " para " + vDestino);
                        break;
                    case 2: // Imprimir matriz de incidência
                        digrafo.imprimirGrafo(); // Chama o método para imprimir a matriz
                        break;
                    case 3: // Consultar grau de um vértice
                        vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para consultar o grau:"));
                        JOptionPane.showMessageDialog(null,
                            "Grau de entrada: " + digrafo.grauEntrada(vertice) + "\n" +
                            "Grau de saída: " + digrafo.grauSaida(vertice)
                        );
                        break;
                    case 4: // Consultar o grau do grafo
                        JOptionPane.showMessageDialog(null, "Grau do grafo: " + digrafo.getNumArestas());
                        break;
                    case 5: // Verificar se é simples ou multigrafo
                        JOptionPane.showMessageDialog(null,
                            digrafo.grafoSimples() ? "O dígrafo é simples." : "O dígrafo possui laços ou arestas paralelas."
                        );
                        break;
                    case 6: // Consultar vizinhos
                        vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para consultar os vizinhos:"));
                        JOptionPane.showMessageDialog(null, digrafo.vizinhos(vertice));
                        break;
                    case 7: // Consultar laços e arestas paralelas
                        JOptionPane.showMessageDialog(null, digrafo.informeMultigrafo());
                        break;
                    case 8: // Informar número de vértices e arestas
                        JOptionPane.showMessageDialog(null, "Vértices: " + digrafo.getNumVertices() + "\nArestas: " + digrafo.getNumArestas());
                        break;
                    case 0: // Sair do loop
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!"); // Opção inválida
                }
            } while (op != 0); // Loop até que o usuário decida sair

        } else if (menu == 2) { // Trabalhando com dígrafos usando matriz de adjacência
            nVertices = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vértices no dígrafo:"));
            DigrafoAdj digrafo = new DigrafoAdj(nVertices); // Criação do objeto DigrafoAdj

            do {
                // Menu de operações para o dígrafo
                op = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Adicionar aresta\n" +
                    "2 - Imprimir matriz de adjacência\n" +
                    "3 - Consultar grau de um vértice\n" +
                    "4 - Verificar se o dígrafo é simples ou multigrafo\n" +
                    "5 - Consultar vértices vizinhos\n" +
                    "6 - Consultar laços e arestas paralelas\n" +
                    "7 - Informar número de vértices e arestas\n" +
                    "8 - Sair\n" +
                    "Informe a opção desejada:"
                ));

                switch (op) {
                    case 1: // Adicionar aresta
                        vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de origem:"));
                        vDestino = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de destino:"));
                        digrafo.adicionarAresta(vOrigem, vDestino); // Chama o método para adicionar a aresta
                        JOptionPane.showMessageDialog(null, "Aresta adicionada de " + vOrigem + " para " + vDestino);
                        break;
                    case 2: // Imprimir matriz de adjacência
                        digrafo.imprimirMatrizAdjacencia(); // Chama o método para imprimir a matriz
                        break;
                    case 3: // Consultar grau de um vértice
                        vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para consultar o grau:"));
                        JOptionPane.showMessageDialog(null,
                            "Grau de entrada: " + digrafo.grauEntrada(vertice) + "\n" +
                            "Grau de saída: " + digrafo.grauSaida(vertice)
                        );
                        break;
                    case 4: // Verificar se é simples ou multigrafo
                        JOptionPane.showMessageDialog(null,
                            digrafo.digrafoSimples() ? "O dígrafo é simples." : "O dígrafo possui laços ou arestas paralelas."
                        );
                        break;
                    case 5: // Consultar vizinhos
                        vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para consultar os vizinhos:"));
                        JOptionPane.showMessageDialog(null, "Vértices vizinhos: " + digrafo.vizinhos(vertice));
                        break;
                    case 6: // Consultar laços e arestas paralelas
                        JOptionPane.showMessageDialog(null, digrafo.informarArestasParalelasELaços());
                        break;
                    case 7: // Informar número de vértices e arestas
                        JOptionPane.showMessageDialog(null, digrafo.informarNumVerticesEArestas());
                        break;
                    case 8: // Sair do loop
                        break; 
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!"); // Opção inválida
                }
            } while (op != 8); // Loop até que o usuário decida sair

        } else if (menu == 3) { // Trabalhando com grafos usando matriz de incidência
            nVertices = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vértices no grafo:"));
            boolean isDigrafo = false; // Grafo não direcionado
            GrafoDigrafo grafo = new GrafoDigrafo(nVertices, isDigrafo); // Criação do objeto GrafoDigrafo
            
            do {
                // Menu de operações para o grafo
                op = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Adicionar aresta\n" +
                    "2 - Imprimir matriz de incidência\n" +
                    "3 - Consultar grau de um vértice\n" +
                    "4 - Verificar se o grafo é simples ou multigrafo\n" +
                    "5 - Consultar vértices vizinhos\n" +
                    "6 - Consultar laços e arestas paralelas\n" +
                    "7 - Informar número de vértices e arestas\n" +
                    "8 - Sair\n" +
                    "Informe a opção desejada:"
                ));

                switch (op) {
                    case 1: // Adicionar aresta
                        vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de origem:"));
                        vDestino = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de destino:"));
                        grafo.adicionarAresta(vOrigem, vDestino); // Chama o método para adicionar a aresta
                        JOptionPane.showMessageDialog(null, "Aresta adicionada entre " + vOrigem + " e " + vDestino);
                        break;
                    case 2: // Imprimir matriz de incidência
                        grafo.imprimirMatrizIncidencia(); // Chama o método para imprimir a matriz
                        break;
                    case 3: // Consultar grau de um vértice
                        vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para consultar o grau:"));
                        JOptionPane.showMessageDialog(null, "Grau do vértice: " + grafo.calcularGrau(vertice));
                        break;
                    case 4: // Verificar se é simples ou multigrafo
                        JOptionPane.showMessageDialog(null,
                            grafo.grafoSimples() ? "O grafo é simples." : "O grafo possui laços ou arestas paralelas."
                        );
                        break;
                    case 5: // Consultar vizinhos
                        vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para consultar os vizinhos:"));
                        JOptionPane.showMessageDialog(null, "Vizinhos do vértice " + vertice + ": " + grafo.listarVizinhos(vertice));
                        break;
                    case 6: // Consultar laços e arestas paralelas
                        JOptionPane.showMessageDialog(null, grafo.identificarArestasParalelasELaços());
                        break;
                    case 7: // Informar número de vértices e arestas
                        JOptionPane.showMessageDialog(null, "Vértices: " + grafo.getNumVertices() + "\nArestas: " + grafo.getNumArestas());
                        break;
                    case 8: // Sair do loop
                        break; // Sair do loop
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!"); // Opção inválida
                }
            } while (op != 8); // Loop até que o usuário decida sair
        }
    }
}
