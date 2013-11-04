package negocio;

public class Atendente extends Funcionario {
    private int qnt_alugueis;

    public Atendente(String cpf, String nome, float salario_base) {
	super(cpf, nome, salario_base, 1);
    }
    
    @Override
    public float calculaGanho() {
        return getSalario_base() + getQnt_alugueis()*25;
    }
    
    public void adcionarAluguel(int alugueis) {
        qnt_alugueis += alugueis;
    }
    
    public int getQnt_alugueis() {
        return qnt_alugueis;
    }

    public void setQnt_vendas(int qnt_vendas) {
        this.qnt_alugueis = qnt_vendas;
    }
}
