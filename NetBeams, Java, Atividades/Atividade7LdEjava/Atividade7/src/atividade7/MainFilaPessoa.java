/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade7;

/**
 *
 * @author 0031432412016
 */
import javax.swing.JOptionPane;

public class MainFilaPessoa {

    public static void main(String[] args) {
        Fila fila = new Fila(5);
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "1 - Cadastrar Pessoa na Fila\n" +
                            "2 - Remover Pessoa da Fila\n" +
                            "3 - Exibir Pessoas na Fila\n" +
                            "4 - Sair\n" +
                            "Informe a opção desejada:"));

            switch (op) {
                case 1:
                    cadastrarPessoaNaFila(fila);
                    break;
                case 2:
                    removerPessoaDaFila(fila);
                    break;
                case 3:
                    fila.exibirFila();
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (op != 4);
    }

    public static void cadastrarPessoaNaFila(Fila fila) {
        String nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
        String cpf = JOptionPane.showInputDialog("Informe o CPF da pessoa:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade da pessoa:"));
        Pessoa pessoa = new Pessoa(nome, cpf, idade);
        fila.enfileirar(pessoa);
    }

    public static void removerPessoaDaFila(Fila fila) {
        Pessoa pessoaRemovida = (Pessoa) fila.desenfileirar();
        if (pessoaRemovida != null) {
            JOptionPane.showMessageDialog(null, "Pessoa removida:\n" + pessoaRemovida);
        } else {
            JOptionPane.showMessageDialog(null, "Fila vazia. Nenhuma pessoa para remover.");
        }
    }
}
