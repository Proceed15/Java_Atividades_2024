/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade6;

/**
 *
 * @author 0031432412016
 */
import javax.swing.JOptionPane;

public class MainPilhaPessoa {

    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "1 - Cadastrar Pessoa\n" +
                            "2 - Remover Pessoa\n" +
                            "3 - Exibir as Pessoas\n" +
                            "4 - Sair"));

            switch (op) {
                case 1:
                    cadastrarPessoa(pilha);
                    break;
                case 2:
                    removerPessoa(pilha);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, pilha.exibirPessoas());
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (op != 4);
    }

    public static void cadastrarPessoa(Pilha pilha) {
        String nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
        String cpf = JOptionPane.showInputDialog("Informe o CPF da pessoa:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade da pessoa:"));
        Pessoa pessoa = new Pessoa(nome, cpf, idade);
        pilha.empilhar(pessoa);
    }

    public static void removerPessoa(Pilha pilha) {
        Pessoa pessoaRemovida = pilha.desempilhar();
        if (pessoaRemovida != null) {
            JOptionPane.showMessageDialog(null, "Pessoa removida:\n" +
                    "Nome: " + pessoaRemovida.getNome() + "\n" +
                    "CPF: " + pessoaRemovida.getCpf() + "\n" +
                    "Idade: " + pessoaRemovida.getIdade());
        } else {
            JOptionPane.showMessageDialog(null, "Pilha vazia. Nenhuma pessoa para remover.");
        }
    }
}
