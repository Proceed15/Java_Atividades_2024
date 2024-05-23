import javax.swing.JOptionPane;

    public class Pessoa {
    private String CPF;
    private String Nome;
    private char Sexo;
    private int Idade;

    public Pessoa(){
        //Quando estava testando se funcionava.
        //JOptionPane.showMessageDialog(null, "Pessoa Criada");
    }

    public Pessoa(String CPF, String Nome, char Sexo, int Idade ){
        this.CPF = CPF;
        this.Nome = Nome;
        this.Sexo = Sexo;
        this.Idade = Idade;
    }


    public void setCPF(String CPF){
    this.CPF = CPF;
}
    public String getCPF(){
        return this.CPF;
    }
    public void setNome(String Nome){
    this.Nome = Nome;
}
    public String getNome(){
        return this.Nome;
    }
    public void setSexo(char Sexo){
    this.Sexo = Sexo;
}
    public char getSexo(){
        return this.Sexo;
    }
    public void setIdade(int Idade){
    this.Idade = Idade;
}
    public int getIdade(){
        return this.Idade;
    }

    public void imprimir(){
        JOptionPane.showMessageDialog(null, "CPF:" + CPF + "\nNome:" + Nome +
                "\nSexo:" + Sexo + "\nIdade" + Idade);
    }

}
