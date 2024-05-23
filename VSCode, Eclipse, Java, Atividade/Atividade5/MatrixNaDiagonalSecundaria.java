import javax.swing.JOptionPane;

public class MatrixNaDiagonalSecundaria {

    public static void main(String[] args) {
        int linhas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de linhas da matriz:"));
        int colunas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de colunas da matriz:"));

        int[][] matriz = new int[linhas][colunas];

        String mensagem = "Digite os elementos da matriz:\n";
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                int elemento = Integer.parseInt(JOptionPane.showInputDialog(mensagem + "Elemento [" + i + "][" + j + "]:"));
                matriz[i][j] = elemento;
            }
        }

        //Descobri isso aqui para a Matriz, ele ajuda a verificar se a resposta está correta.
        StringBuilder matrizOriginal = new StringBuilder("Matriz original:\n");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizOriginal.append(matriz[i][j]).append("\t");
            }
            matrizOriginal.append("\n");
        }

        StringBuilder diagonalSecundaria = new StringBuilder("Elementos da diagonal secundária:\n");
        for (int i = 0; i < linhas; i++) {
            diagonalSecundaria.append(matriz[i][colunas - i - 1]).append(" ");
        }

        // Mostra a matriz inserida e os números ou letras (é possível) da diagonal secundária.
        JOptionPane.showMessageDialog(null, matrizOriginal.toString() + diagonalSecundaria.toString());
    }
}
