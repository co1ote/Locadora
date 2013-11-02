package negocio;

public class Carro {
    private String chassi;
    private float diaria;
    private boolean alugado;
    private String modelo;
    private String cor;
    private String placa;
    private int ano;
	
    public Carro(String chassi, float diaria)
    {
        setChassi(chassi);
        setDiaria(diaria);
        setAlugado(false);
    }
	
    public String getChassi() {
        return chassi;
    }
    public float getDiaria() {
        return diaria;
    }
    public boolean isAlugado() {
        return alugado;
    }
    public String getModelo() {
        return modelo;
    }
    public String getCor() {
        return cor;
    }
    public String getPlaca() {
        return placa;
    }
    public int getAno() {
        return ano;
    }
   
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    public void setDiaria(float diaria) {
        this.diaria = diaria;
    }
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;   
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
}
