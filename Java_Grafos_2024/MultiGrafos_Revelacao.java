//Atividade Grafos (App.java) 2024 Imprime Matriz com o resultado igual o número de Colunas e Linhas
 
import javax.swing.JOptionPane;
 
 
 
public class MultiGrafos_Revelacao {
 
    public static void main(String[] args) throws Exception {
 
        int vertices = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos vértices serão: "));
 
        int grafo[][] = new int[vertices][vertices];
 
 
 
        // Apaga todos os valores da matriz para o i e o j
 
        for(int i = 0; i < vertices; i++)

        {
 
            for(int j = 0; j < vertices; j++)
 
            {
 
                grafo[i][j] = 0;
 
            }
 
        }
 
 
 
        //  Teste adicionando aos vértices e exibindo
 
        String testeV = "";
 
 
 
        for(int x = 0; x < vertices; x++)
 
        {
 
            for(int y = 0; y < vertices; y++)
 
            {
 
                testeV += " " + grafo[x][y];
 
            }
 
            testeV += "\n";
 
        }
 
 
 
        System.out.println(testeV);
 
        //Exibindo o Resultado
 
 
 
        int arestas = Integer.parseInt(JOptionPane.showInputDialog("Informe quantas arestas serão: "));
 
       
 
        JOptionPane.showMessageDialog(null, "Agora Digite os Valores das Linhas e Colunas: ");
 
        for(int i = 0; i < arestas; i++)
 
        {
 
            JOptionPane.showMessageDialog(null, "Valores (V!=0)");
            int v1 = 0, v2 =0;
            do{
                v1 = Integer.parseInt(JOptionPane.showInputDialog("Primeira Posição (Linha): "));
            }while(v1 == 0 || v1 > vertices);
            do{
                v2 = Integer.parseInt(JOptionPane.showInputDialog("Segunda Posição (Coluna): "));
            }while(v2 == 0 || v2 > vertices);
       
 
            // Conforme valores fornecidos aumenta as ligações entre os vértices
 
            grafo[v1-1][v2-1] += 1;
 
 
 
            // CASO sejam vértices diferentes reflete o número na coordenada correspondente a imagem
            // Basicamente espelha o vértice de um lado no outro na mesma linha
 
            if(v1 != v2)
 
            {
 
                grafo[v2-1][v1-1] += 1;
 
            }
 
 
 
            //Teste 2 Adicionando aos vértices e exibindo
 
            String testeV2 = "";
 
 
 
            for(int x = 0; x < vertices; x++)
 
            {
 
                for(int y = 0; y < vertices; y++)
 
                {
 
                    testeV2 += " " + grafo[x][y];
 
                }
 
                testeV2 += "\n";
 
            }
 
 
 
            System.out.println(testeV2);
 
            //Exibindo o Resultado 2
 
        }
 
 
 
        // Usando uma string como nos exemplos, monta uma matriz para ser exibida posteriormente
 
        String matriz = "";
 
 
 
        for(int i = 0; i < vertices; i++)
 
        {
 
            for(int j = 0; j < vertices; j++)
 
            {
 
                matriz += "   " + grafo[i][j];
 
            }
 
            matriz += "\n";
 
        }
 
       
 
        // mostra a matriz gerada a partir do grafo
 
        JOptionPane.showMessageDialog(null, "A matriz desse grafo é: \n" + matriz);
 
       
 
        // Utiliza a função de contar os vértices
 
        contaV(grafo, vertices);
 
 
 
        // Utiliza a função de verificação para caso o grafo seja simples ou não
 
        if(verificaSMV(grafo, vertices))
 
        {
 
            JOptionPane.showMessageDialog(null, "O grafo é Multigrafo");
 
        }
 
        else
 
        {
 
            JOptionPane.showMessageDialog(null, "O grafo é Simples");
 
        }
 
    }
 
 
 
    public static void contaV(int grafo[][], int vertices)
 
    {
 
        // conta quantas ligações cada vértice têm
 
        for(int i = 0; i < vertices; i++)
 
        {
 
            String qtdVertices = "\nO vértice de número " + (i+1) + " possui grau equivalente a ";
 
            int contaV = 0;
 
           
 
            for(int j = 0; j < vertices; j++)
 
            {
 
                if(i == j)
 
                {
 
                    // CASO tenha um laço
 
                    contaV += grafo[i][j] * 2;
 
                }
 
                else
 
                {
 
                    contaV += grafo[i][j];
 
                }
 
            }
 
 
 
            JOptionPane.showMessageDialog(null, qtdVertices + contaV);
 
        }
 
    }

    // Função de verificação para caso o grafo seja simples ou não
 
    public static boolean verificaSMV(int grafo[][], int vertices)
 
    {
 
        // Começa a verificação para ser um Grafo Simples
 
        for(int i = 0; i < vertices; i++)
 
        {
 
            for(int j = 0; j < vertices; j++)
 
            {
                if (grafo[i][j] == 0) {
                    continue;
                }
                // Verifica se possui um valor maior que 1 em busca de laços ou arestas paralelas
 
                if(grafo[i][j] > 1 || i == j && grafo[i][j] >= 1)
 
                {
 
                    return true;
 
                }
 
            }
 
        }
 
        return false;
 
    }
 
}