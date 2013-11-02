package negocio;

import java.util.Date;

public class Aluguel {
    private float valorTotal;
    private Date dataInicio;
    private Cliente locador;
    private Carro carro;
    private Date dataEntrega;
	
    public Aluguel(Cliente locador, Carro carro, Date dataEntrega) {
	setLocador(locador);
	setVeiculo(carro);
	setDataInicio(new Date());
        setDataEntrega(dataEntrega);
        calculaValorTotal();
    }

    private void calculaValorTotal() {
        long dias = (getDataEntrega().getTime() - getDataEntrega().getTime())*60*1000*60*24;
	this.valorTotal = dias*carro.getDiaria();
    }
	
    public float getValorTotal() {
	calculaValorTotal();
	return valorTotal;
    }
    public Date getDataInicio() {
    	return dataInicio;
    }
    public Cliente getLocador() {
	return locador;
    }
    public Carro getCarro() {
	return carro;
    }
    public Date getDataEntrega() {
	return dataEntrega;
    }

    public void setValorTotal(float valorTotal) {
	this.valorTotal = valorTotal;
    }
    public void setDataInicio(Date dataInicio) {
	this.dataInicio = dataInicio;
    }
    public void setLocador(Cliente locador) {
	this.locador = locador;
    }
    public void setVeiculo(Carro carro) {
	this.carro = carro;
    }
    public void setDataEntrega(Date dataEntrega) {
	this.dataEntrega = dataEntrega;
    }	
}
