/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade8;

/**
 *
 * @author 0031432412016
 */
import javax.swing.JOptionPane;

public class Pilha {
    private int topo;
    private int tamanhoMaximo;
    private Object vetor[];
    private int tamanhoAtual;

    public Pilha(int tam) {
        topo = -1;
        tamanhoMaximo = tam;
        vetor = new Object[tam];
        tamanhoAtual = 0;
    }

    public boolean vazia() {
        return tamanhoAtual == 0;
    }

    public boolean cheia() {
        return tamanhoAtual == tamanhoMaximo;
    }

    public void empilhar(Object elem) {
        if (!cheia()) {
            topo++;
            vetor[topo] = elem;
            tamanhoAtual++;
        } else {
            JOptionPane.showMessageDialog(null, "PILHA CHEIA!");
        }
    }

    public Object desempilhar() {
        Object valorDesempilhado;
        if (vazia()) {
            valorDesempilhado = "Pilha Vazia";
        } else {
            valorDesempilhado = vetor[topo];
            topo--;
            tamanhoAtual--;
        }
        return valorDesempilhado;
    }

    public String ExibePilha() {
        String elementos = "";
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "PILHA VAZIA!");
        } else {
            for (int i = topo; i >= 0; i--) {
                elementos += "\nElemento " + vetor[i] + " - posição " + i;
            }
        }
        return elementos;
    }

    public int Tamanho() {
        return tamanhoAtual;
    }
}
