/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade4;

/**
 *
 * @author 0031432412016
 */
import javax.swing.JOptionPane;

public class Pilha {
    private String[] elementos;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new String[capacidade];
        this.topo = -1;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == capacidade - 1;
    }

    public void empilhar(String elemento) {
        if (!cheia()) {
            topo++;
            elementos[topo] = elemento;
        } else {
            JOptionPane.showMessageDialog(null, "Pilha Cheia!");
        }
    }

    public String desempilhar() {
        if (!vazia()) {
            String elementoDesempilhado = elementos[topo];
            topo--;
            return elementoDesempilhado;
        } else {
            JOptionPane.showMessageDialog(null, "Pilha Vazia!");
            return null;
        }
    }

    public String topo() {
        if (!vazia()) {
            return elementos[topo];
        } else {
            JOptionPane.showMessageDialog(null, "Pilha Vazia!");
            return null;
        }
    }

    public int tamanho() {
        return capacidade;
    }
}
