import javax.swing.JOptionPane;

public class Funcionario {

   int cracha;
   String nome;
   char TipoVinculo;
   float ValorHora;
   float QtdeHora;
   float Salario;
   float ValorDesconto;


   public Funcionario(){
        //Testado para ver se funcionava.
       //JOptionPane.showMessageDialog(null, "Funcionario Criado");
   }

 public Funcionario(int cracha, String nome, char TipoVinculo, float ValorHora, float QtdeHora,  float Salario, float ValorDesconto)
    {
       this.cracha = cracha;
       this.nome = nome;
       this.TipoVinculo = TipoVinculo;
       this.ValorHora = ValorHora;
       this.QtdeHora = ValorHora;
       this.Salario = Salario;
       this.ValorDesconto = ValorDesconto;

    }
    public void setcracha(int cracha){
        this.cracha = cracha;
    }
    public int getcracha(){
        return this.cracha;
    }
    public void setnome( String nome){
        this.nome = nome;
    }
    public String getnome(){
        return this.nome;
    }
    public void setTipoVinculo( char TipoVinculo){
        this.TipoVinculo = TipoVinculo;
    }
    public char getTipoVinculo(){
        return this.TipoVinculo;
    }
     public void setValorHora( float ValorHora){
        this.ValorHora = ValorHora;
    }
    public float getValorHora(){
        return this.ValorHora;
    }
     public void setQtdeHora( float QtdeHora){
        this.QtdeHora = QtdeHora;
    }
    public float getQdtdeHora(){
        return this.QtdeHora;
    }
     public void setValorDesconto ( float ValorDesconto){
        this.ValorDesconto = ValorDesconto;
    }
    public float getValorDesconto(){
        return this.ValorDesconto;
    }
     public void setSalario( float Salario){
        this.Salario = Salario;
    }
    public float getSalario(){
        return this.Salario;
    }
    public float calcularValorSalario() {
        if (TipoVinculo == 'H') {
            return (ValorHora * QtdeHora) - ValorDesconto;
        } else {
            return Salario - ValorDesconto;
        }
    }
    public void imprimir(){
        float ValoraReceber = calcularValorSalario();
        JOptionPane.showMessageDialog(null, "Cracha:" +cracha  + "\nNome:" + nome +
                "\nTipo do Vinculo:" + TipoVinculo  + "\n Valor do Sálario" + (TipoVinculo == 'H'?(ValorHora * QtdeHora) : Salario) + "\n Valor do Desconto" + ValorDesconto +
                "\nValor a Receber:" + ValoraReceber );

    }
}
