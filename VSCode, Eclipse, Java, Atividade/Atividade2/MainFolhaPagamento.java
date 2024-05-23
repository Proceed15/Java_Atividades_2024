import javax.swing.JOptionPane;


public class MainFolhaPagamento {
    public static void main(String[] args) {
        Funcionario F = new Funcionario();

        int opc;
        do{
         opc= Integer.parseInt(JOptionPane.showInputDialog("Menu:\n" +
                "1 – Criar Funcionário\n" +
                "2 – Mostrar Folha de Pagamento\n" +
                "3 – Alterar remuneração\n" +
                "4 – Sair"));

        switch(opc){
            case 1:
               F.setcracha(Integer.parseInt(JOptionPane.showInputDialog("Informe o seu cracha")));
               F.setnome(JOptionPane.showInputDialog("Informe o seu Nome:"));
               char TipoVinculo = JOptionPane.showInputDialog("Informe o seu tipo de Vinculo H ou M:").charAt(0);
                F.setTipoVinculo(TipoVinculo);
               if(TipoVinculo == 'H'){
               F.setValorHora (Float.parseFloat(JOptionPane.showInputDialog("Informe seu valor por hora:")));
               F.setQtdeHora (Float.parseFloat(JOptionPane.showInputDialog("Informe a sua quantidade de horas:")));
               }
               else{
               F.setSalario (Float.parseFloat(JOptionPane.showInputDialog("Informe a seu salario:")));
               }
               F.setValorDesconto (Float.parseFloat(JOptionPane.showInputDialog("Informe seu valor desconto:")));

               JOptionPane.showMessageDialog(null, "Funcionário criado com sucesso!");
               break;
           case 2:
               F.imprimir();
               break;
           case 3:
               if(F.TipoVinculo == 'H'){
                   F.setValorHora (Float.parseFloat(JOptionPane.showInputDialog("Informe seu valor por hora:")));
               F.setQtdeHora (Float.parseFloat(JOptionPane.showInputDialog("Informe a sua quantidade de horas:")));
               }
               else{
                   F.setSalario (Float.parseFloat(JOptionPane.showInputDialog("Informe a seu salario:")));
               }
               break;
           case 4:
               System.exit(0);
               break;
        }
        }
        while(opc !=4);
    }

}
