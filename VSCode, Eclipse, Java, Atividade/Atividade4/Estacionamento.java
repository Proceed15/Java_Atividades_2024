import javax.swing.JOptionPane;

public class Estacionamento {

    public static void main(String[] args) {
        Pilha pilhaEstacionamento = new Pilha(10);

        while (!pilhaEstacionamento.cheia()) {
            String placa = JOptionPane.showInputDialog(null, "Digite a placa do carro, no máximo 10:");
            if (placa.isEmpty()) {
                break;
            }
            pilhaEstacionamento.empilhar(placa);
        }

        String placaProcurada = JOptionPane.showInputDialog(null, "Digite a placa do carro que vai deixar a rua:");
        String SequenciaR = Removidos(pilhaEstacionamento, placaProcurada);

        if (SequenciaR != null) {
            JOptionPane.showMessageDialog(null, "Sequência de carros a serem retirados:\n" + SequenciaR);
        } else {
            JOptionPane.showMessageDialog(null, "Carro não encontrado no estacionamento.");
        }
    }

    public static String Removidos(Pilha pilha, String placaProcurada) {
        Pilha temp = new Pilha(pilha.tamanho());
        String sequenciaRemocao = "";
        boolean encontrado = false;

        while (!pilha.vazia()) {
            String placa = pilha.desempilhar();
            if (placa.equals(placaProcurada)) {
                encontrado = true;
                break;
            }
            temp.empilhar(placa);
        }

        if (encontrado) {
            while (!temp.vazia()) {
                String placa = temp.desempilhar();
                sequenciaRemocao += placa + "\n";
            }
            return sequenciaRemocao;
        }

        while (!temp.vazia()) {
            pilha.empilhar(temp.desempilhar());
        }

        return null;
    }

}
