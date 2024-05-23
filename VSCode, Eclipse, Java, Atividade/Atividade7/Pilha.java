import javax.swing.JOptionPane;

public class Pilha {
    private Object[] elementos;
    private int topo;
    private int capacidade;

    public Pilha() {
        this.capacidade = 100; // Capacidade padrão
        this.elementos = new Object[capacidade];
        this.topo = -1;
    }

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Object[capacidade];
        this.topo = -1;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == capacidade - 1;
    }

    public void empilhar(Object elemento) {
        if (!cheia()) {
            topo++;
            elementos[topo] = elemento;
        } else {
            JOptionPane.showMessageDialog(null, "Pilha Cheia!");
        }
    }

    public Object desempilhar() {
        if (!vazia()) {
            Object elementoDesempilhado = elementos[topo];
            topo--;
            return elementoDesempilhado;
        } else {
            JOptionPane.showMessageDialog(null, "Pilha Vazia!");
            return null;
        }
    }

    public Object topo() {
        if (!vazia()) {
            return elementos[topo];
        } else {
            JOptionPane.showMessageDialog(null, "Pilha Vazia!");
            return null;
        }
    }
}
