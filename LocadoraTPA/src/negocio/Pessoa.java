package negocio;

public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected String telefone;
    
    public Pessoa(String cpf, String nome) {
        setNome(nome);
        setCpf(cpf);
    }
    
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
