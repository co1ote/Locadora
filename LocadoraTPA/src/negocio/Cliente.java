package negocio;

public class Cliente extends Pessoa {
    
    private String endereco;
    private int anoCNH;
    private int anoValidadeCNH;
	
    public Cliente(String nome, String cpf, int anoCNH, int anoValidadeCNH)
    {
	super(cpf,nome);
        setAnoCNH(anoCNH);
	setAnoValidadeCNH(anoValidadeCNH);
    }
    public String getEndereco() {
        return this.endereco;
    }
    public int getAnoCNH() {
	return this.anoCNH;
    }
    public int getAnoValidadeCNH() {
	return this.anoValidadeCNH;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setAnoCNH(int anoCNH) {
	this.anoCNH = anoCNH;
    }
    public void setAnoValidadeCNH(int anoValidadeCNH) {
	this.anoValidadeCNH = anoValidadeCNH;
    }
}
