package negocio;

public abstract class Funcionario extends Pessoa {
    private float salario_base;
    private int codigo;

    public Funcionario(String cpf, String nome, float salario_base, int codigo)
    {
        super(cpf, nome);
	setSalario_base(salario_base);
        setCodigo(codigo);
    }
	
    public abstract float calculaGanho();
	
    public float getSalario_base() {
	return salario_base;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setSalario_base(float salario_base) {
	this.salario_base = salario_base;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
