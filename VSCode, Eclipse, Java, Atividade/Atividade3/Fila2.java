import javax.swing.JOptionPane;

public class Fila2 {

    public static void preencherFila(Fila fila) {
        String input;
        int num;
        boolean continua = true;

        while (continua && !fila.cheia()) {
            input = JOptionPane.showInputDialog("Informe um número inteiro para adicionar à fila (ou deixe em branco para encerrar está fila):");
            if (input == null || input.isEmpty()) {
                continua = false;
            } else {
                try {
                    num = Integer.parseInt(input);
                    fila.enfileirar(num);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                }
            }
        }

        if (fila.cheia()) {
            JOptionPane.showMessageDialog(null, "A fila está cheia. Preencha a próxima.");
        }
    }
}
