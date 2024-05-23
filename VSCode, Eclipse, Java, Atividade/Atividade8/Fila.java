import javax.swing.JOptionPane;

public class Fila {
    private int tamanho;
    private int inicio;
    private int fim;
    private int total;
    private int vetor[];

    public Fila(int tam) {
        inicio = 0;
        fim = 0;
        total = 0;
        vetor = new int[tam];
        tamanho = tam;
    }

    public boolean vazia() {
        return total == 0;
    }

    public boolean cheia() {
        return total == tamanho;
    }

    public void enfileirar(int elem) {
        if (!cheia()) {
            vetor[fim] = elem;
            fim++;
            total++;
        } else {
            JOptionPane.showMessageDialog(null, "Fila Cheia!");
        }
    }

    public int desenfileirar() {
        int elem = -1;
        if (!vazia()) {
            elem = vetor[inicio];
            inicio++;
            total--;
        } else {
            JOptionPane.showMessageDialog(null, "Fila Vazia!");
        }
        return elem;
    }

    public void exibeFila() {
        String elementos = "Elementos da Fila:";
        for (int i = inicio; i < fim; i++) {
            elementos += "\nElemento " + vetor[i] + " - posição " + i;
        }
        JOptionPane.showMessageDialog(null, elementos);
    }

    public int getTamanho() {
        return total;
    }
}
