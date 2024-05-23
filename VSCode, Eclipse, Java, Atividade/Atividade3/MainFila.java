import javax.swing.JOptionPane;

public class MainFila {

    public static void main(String[] args) {
        Fila F1 = new Fila(10);
        Fila F2 = new Fila(10);

        Fila2.preencherFila(F1);

        Fila2.preencherFila(F2);

        if (F1.getTamanho() > F2.getTamanho()) {
            JOptionPane.showMessageDialog(null, "A Fila F1 tem mais elementos do que a Fila F2.");
        } else if (F1.getTamanho() < F2.getTamanho()) {
            JOptionPane.showMessageDialog(null, "A Fila F2 tem mais elementos do que a Fila F1.");
        } else {
            JOptionPane.showMessageDialog(null, "As filas F1 e F2 têm o mesmo número de elementos.");
        }
    }
}
