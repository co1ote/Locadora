package negocio;

public class Atendente extends Funcionario {
    private int qnt_vendas;

    public Atendente(String cpf, String nome, float salario_base) {
	super(cpf, nome, salario_base, 1);
    }
    
    @Override
    public float calculaGanho() {
        return getSalario_base() + getQnt_vendas()*25;
    }
    
    public void adcionarVendas(int vendas) {
        qnt_vendas += vendas;
    }
    
    public int getQnt_vendas() {
        return qnt_vendas;
    }

    public void setQnt_vendas(int qnt_vendas) {
        this.qnt_vendas = qnt_vendas;
    }
}
