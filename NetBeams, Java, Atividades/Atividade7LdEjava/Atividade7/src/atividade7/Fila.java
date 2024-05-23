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

public class Fila {
    private Pilha inicio;
    private Pilha fim;
    private int tamanho;
    private int total;

    public Fila(int tam) {
        inicio = new Pilha();
        fim = new Pilha();
        tamanho = tam;
        total = 0;
    }

    public boolean vazia() {
        return total == 0;
    }

    public boolean cheia() {
        return total == tamanho;
    }

    public void enfileirar(Object elemento) {
        if (!cheia()) {
            fim.empilhar(elemento);
            total++;
        } else {
            JOptionPane.showMessageDialog(null, "Fila Cheia!");
        }
    }

    public Object desenfileirar() {
        Object excluido = null;
        if (!vazia()) {
            while (!fim.vazia()) {
                inicio.empilhar(fim.desempilhar());
            }
            excluido = inicio.desempilhar();
            total--;
            while (!inicio.vazia()) {
                fim.empilhar(inicio.desempilhar());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Vazia!");
        }
        return excluido;
    }

    public void exibirFila() {
        StringBuilder elementos = new StringBuilder();
        Pilha temp = fim; // Aqui inverte
        while (!temp.vazia()) {
            Object elemento = temp.desempilhar();
            elementos.append(elemento).append("\n");
            inicio.empilhar(elemento); // Aqui volta a pilha original.
        }
        JOptionPane.showMessageDialog(null, elementos.toString());
        // Loop para a volta.
        while (!inicio.vazia()) {
            fim.empilhar(inicio.desempilhar());
        }
    }
}
