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

public class PilhaRua {
    private String[] placas;
    private int topo;
    private int capacidade;

    public PilhaRua(int capacidade) {
        this.capacidade = capacidade;
        this.placas = new String[capacidade];
        this.topo = -1;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == capacidade - 1;
    }

    public void empilhar(String placa) {
        if (!cheia()) {
            topo++;
            placas[topo] = placa;
        } else {
            JOptionPane.showMessageDialog(null, "Pilha de placas cheia!");
        }
    }

    public String desempilhar() {
        if (!vazia()) {
            return placas[topo--];
        } else {
            JOptionPane.showMessageDialog(null, "Pilha de placas vazia!");
            return null;
        }
    }

    public String[] getPlacas() {
        return placas;
    }
}
