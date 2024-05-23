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

    public String desenfileirar() {
        String elem;
        if (!vazia()) {
            elem = String.valueOf(vetor[inicio]);
            inicio++;
            total--;
        } else {
            elem = "Fila Vazia!";
        }
        return elem;
    }

    public void exibeFila() {
        for (int i = inicio; i < fim; i++) {
            JOptionPane.showMessageDialog(null, "Elemento " + i + " da fila: " + vetor[i]);
        }
    }

    public int getTamanho() {
        return total;
    }
}
