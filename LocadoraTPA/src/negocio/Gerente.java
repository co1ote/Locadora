package negocio;

public class Gerente extends Funcionario {
    private int banco_horas;
    
    public Gerente(String cpf, String nome, float salario_base) {
        super(cpf, nome, salario_base, 0);
    }
    
    @Override
    public float calculaGanho() {
        return getSalario_base() + getBanco_horas()*50;
    }
    
    public void adcionarHoras(int horas) {
        banco_horas += horas;
    }
    
    public int getBanco_horas() {
        return banco_horas;
    }

    public void setBanco_horas(int banco_horas) {
        this.banco_horas = banco_horas;
    }
}
