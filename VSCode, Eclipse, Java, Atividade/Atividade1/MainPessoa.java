
import javax.swing.JOptionPane;

public class MainPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Pessoa P = new Pessoa();

       int opc;

       do{
       opc= Integer.parseInt(JOptionPane.showInputDialog(
                 "1 - Criar Pessoa\n"
                + "2 - Mostrar Pessoa\n"
                + "3 - Sair"
                ));

       switch(opc){

           case 1:
               P.setCPF(JOptionPane.showInputDialog("Informe o seu CPF"));
               P.setNome(JOptionPane.showInputDialog("Informe o seu Nome:"));
               P.setSexo(JOptionPane.showInputDialog("Informe o seu Sexo M ou F:").charAt(0));
               P.setIdade (Integer.parseInt(JOptionPane.showInputDialog("Informe a sua idade:")));
               break;
           case 2:
               P.imprimir();
               break;
           case 3:
               System.exit(0);
               break;

       }
    }
    while(opc !=3);
       }



}
