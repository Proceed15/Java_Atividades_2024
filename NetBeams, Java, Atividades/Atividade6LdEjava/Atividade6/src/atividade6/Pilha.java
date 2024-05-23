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

public class Pilha {
    private int topo;
    private int tamanho;
    private Pessoa[] vetor;

    public Pilha(int tam) {
        topo = -1;
        tamanho = tam;
        vetor = new Pessoa[tam];
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == tamanho - 1;
    }

    public void empilhar(Pessoa pessoa) {
        if (!cheia()) {
            topo++;
            vetor[topo] = pessoa;
        } else {
            JOptionPane.showMessageDialog(null, "PILHA CHEIA!");
        }
    }

    public Pessoa desempilhar() {
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "PILHA VAZIA!");
            return null;
        } else {
            Pessoa pessoaRemovida = vetor[topo];
            topo--;
            return pessoaRemovida;
        }
    }

    public String exibirPessoas() {
        StringBuilder elementos = new StringBuilder();
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "PILHA VAZIA!");
        } else {
            for (int i = topo; i >= 0; i--) {
                elementos.append("\nNome: ").append(vetor[i].getNome()).append(", CPF: ").append(vetor[i].getCpf()).append(", Idade: ").append(vetor[i].getIdade());
            }
        }
        return elementos.toString();
    }
}
