import javax.swing.JOptionPane;

public class MainMenu {

    public static void main(String[] args) {
        Pilha p = new Pilha(5);
        Fila f = new Fila(5);
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n"
                            + "1 - Inserir elementos na Pilha\n"
                            + "2 - Inserir elementos na Fila\n"
                            + "3 - Remover elemento da Pilha e inserir na Fila\n"
                            + "4 - Remover elemento da Fila e inserir na Pilha\n"
                            + "5 - Consultar a quantidade de elementos da Pilha\n"
                            + "6 - Consultar a quantidade de elementos na Fila\n"
                            + "7 - Exibir os elementos existentes na Pilha (E a soma, a média, o maior e o menor valor)\n"
                            + "8 - Exibir os elementos existentes na Fila (E a soma, a média, o maior e o menor valor)\n"
                            + "0 - Sair\n"
                            + "Informe a opção desejada:"));

            switch (op) {
                case 1:
                    Object valorPilha = JOptionPane.showInputDialog("Informe o valor a ser empilhado:");
                    try {
                        int valorInt = Integer.parseInt((String) valorPilha);
                        p.empilhar(valorInt);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido na pilha. Não é possível empilhar elementos.");
                    }
                    break;
                case 2:
                    int valorFila = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor a ser inserido na Fila:"));
                    f.enfileirar(valorFila);
                    break;
                case 3:
                    if (!p.vazia()) {
                        Object valorRemovido = p.desempilhar();
                        if (valorRemovido instanceof Integer) {
                            int valorConvertido = (int) valorRemovido;
                            f.enfileirar(valorConvertido);
                            JOptionPane.showMessageDialog(null, "Valor removido da Pilha e inserido na Fila!");
                            ExibirFilaOp(f);
                        } else {
                            JOptionPane.showMessageDialog(null, "Valor inválido na pilha. Não é possível remover elementos.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Pilha vazia. Não é possível remover elementos.");
                    }
                    break;
                case 4:
                    if (!f.vazia()) {
                        int valorRemovido = f.desenfileirar();
                        p.empilhar(valorRemovido);
                        JOptionPane.showMessageDialog(null, "Valor removido da Fila e inserido na Pilha!");
                        ExibirPilhaOp(p);
                    } else {
                        JOptionPane.showMessageDialog(null, "Fila vazia. Não é possível remover elementos.");
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Quantidade de elementos na Pilha: " + p.Tamanho());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Quantidade de elementos na Fila: " + f.getTamanho());
                    break;
                case 7:
                    if (!p.vazia()) {
                        ExibirPilhaOp(p);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pilha vazia.");
                    }
                    break;
                case 8:
                    if (!f.vazia()) {
                        ExibirFilaOp(f);
                    } else {
                        JOptionPane.showMessageDialog(null, "Fila vazia.");
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (op != 0);
    }

    private static void ExibirPilhaOp(Pilha p) {
        StringBuilder elementos = new StringBuilder("Elementos da Pilha:");
        int soma = 0;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int quantidadeElementos = 0;

        while (!p.vazia()) {
            Object valor = p.desempilhar();
            if (valor instanceof Integer) {
                int valorInt = (int) valor;
                elementos.append("\n").append(valorInt);
                soma += valorInt;
                if (valorInt > maior) {
                    maior = valorInt;
                }
                if (valorInt < menor) {
                    menor = valorInt;
                }
                quantidadeElementos++;
            }
        }

        if (quantidadeElementos > 0) {
            double media = (double) soma / quantidadeElementos;
            JOptionPane.showMessageDialog(null, elementos.toString() +
                    "\nSoma: " + soma +
                    "\nMédia: " + media +
                    "\nMaior valor: " + maior +
                    "\nMenor valor: " + menor);
        } else {
            JOptionPane.showMessageDialog(null, "Pilha vazia.");
        }
    }

    private static void ExibirFilaOp(Fila f) {
        StringBuilder elementos = new StringBuilder("Elementos da Fila:");
        int soma = 0;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int quantidadeElementos = 0;

        while (!f.vazia()) {
            int valor = f.desenfileirar();
            elementos.append("\n").append(valor);
            soma += valor;
            if (valor > maior) {
                maior = valor;
            }
            if (valor < menor) {
                menor = valor;
            }
            quantidadeElementos++;
        }

        if (quantidadeElementos > 0) {
            double media = (double) soma / quantidadeElementos;
            JOptionPane.showMessageDialog(null, elementos.toString() +
                    "\nSoma: " + soma +
                    "\nMédia: " + media +
                    "\nMaior valor: " + maior +
                    "\nMenor valor: " + menor);
        } else {
            JOptionPane.showMessageDialog(null, "Fila vazia.");
        }
    }
}
