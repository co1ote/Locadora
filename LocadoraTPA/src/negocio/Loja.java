package negocio;

import java.util.ArrayList;
import java.util.Date;

public class Loja {
    private ArrayList<Cliente> clientes;
    private ArrayList<Carro> carros;
    private ArrayList<Aluguel> locacoes;
    private ArrayList<Funcionario> funcionarios;

    public Loja() {
       clientes = new ArrayList<Cliente>();
       carros = new ArrayList<Carro>();
       locacoes = new ArrayList<Aluguel>();
       funcionarios = new ArrayList<Funcionario>();
    }
        
    public void adcionarCarro(Carro carro) {
        carros.add(carro);
    }
    public void adcionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }   
    public void adcionarLocacao(Carro carro, Cliente locador, int dias) {
        Date dataEntrega = new Date();
        dataEntrega.setTime(dataEntrega.getTime() + dias*60*1000*60*24);
        Aluguel aluguel = new Aluguel(locador, carro, dataEntrega);
        locacoes.add(aluguel);
        carro.setAlugado(true);
    }
    public void adcionarFuncionario(Atendente vendedor) {
        funcionarios.add(vendedor);
    }
    public void adcionarFuncionario(Gerente gerente) {
        funcionarios.add(gerente);
    }
    
    public String removerCarro(String chassi) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getChassi().equals(chassi))
            {
                carros.remove(i);
                return "REMOVIDO";
            }
        }
        return "NÃO FOI ENCONTRADO";
    }
    public String removerCliente(String cpf) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf))
            {
                clientes.remove(i);
                return "REMOVIDO";
            }
        }
        return "NÃO FOI ENCONTRADO";
    }
    public String removerLocacao(String cpf, String chassi) {
        for (int i = 0; i < locacoes.size(); i++) {
            Aluguel aluguel = locacoes.get(i);
            if (aluguel.getCarro().getChassi().equals(chassi) && aluguel.getLocador().getCpf().equals(cpf))
            {
                locacoes.remove(i);
                for (int j=0; j < carros.size(); j++) {
                    if (carros.get(j).getChassi().equals(chassi))
                        carros.get(j).setAlugado(false);
                }
                return "REMOVIDO";
            }
        }
        return "NÃO FOI ENCONTRADO";
    }
    public String removerFuncionario(String cpf) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCpf().equals(cpf))
            {
                funcionarios.remove(i);
                return "REMOVIDO";
            }
        }
        return "NÃO FOI ENCONTRADO";
    }
    
    public boolean existeCarro(String chassi) {
        for(int i= 0; i < carros.size();i++){
            if(carros.get(i).getChassi().equals(chassi)) {
                return true;
            }
        }
        return false;
    }
    public boolean existeCliente(String cpf) {
        for(int i= 0; i < clientes.size();i++){
            if(clientes.get(i).getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    public boolean existeFuncionario(String cpf) {
        for(int i= 0; i < funcionarios.size();i++){
            if(funcionarios.get(i).getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public String editarCarro(String chassi,float diaria, String cor, String modelo, String placa, int ano){
        for(int i= 0; i < carros.size();i++){
            if(carros.get(i).getChassi().equals(chassi)){
                carros.get(i).setAno(ano);
                carros.get(i).setChassi(chassi);
                carros.get(i).setCor(cor);
                carros.get(i).setModelo(modelo);
                carros.get(i).setPlaca(placa);
                carros.get(i).setDiaria(diaria);
                return "EDITADO COM SUCESSO";
            }
        }
        return "ERRO AO EDITAR";
    }
    
    public String editarCliente(String cpf, String nome, String telefone, String endereco, int anoCNH, int validadeCNH){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getCpf().equals(cpf)){
                clientes.get(i).setAnoValidadeCNH(validadeCNH);
                clientes.get(i).setAnoCNH(anoCNH);
                clientes.get(i).setEndereco(endereco);
                clientes.get(i).setTelefone(telefone);
                clientes.get(i).setNome(nome);
                clientes.get(i).setCpf(cpf);
                return "EDITADO COM SUCESSO";
            }
        }
        return "EDITADO COM SUCESSO";
    }
    
    public String editarFuncionario(String cpf, String nome, String telefone, float salario_base){
        for(int i = 0; i<funcionarios.size(); i++){
            if(funcionarios.get(i).getCpf().equals(cpf)){                
                funcionarios.get(i).setTelefone(telefone);
                funcionarios.get(i).setNome(nome);
                funcionarios.get(i).setCpf(cpf);
                return "EDITADO COM SUCESSO";
            }
        }
        return "EDITADO COM SUCESSO";
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public ArrayList<Carro> getCarros() {
        return carros;
    }
    public ArrayList<Aluguel> getLocacoes() {
        return locacoes;
    }
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public ArrayList<Funcionario> getAtendentes() {
        ArrayList<Funcionario> atendentes = new ArrayList<Funcionario>();
        for (int i=0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCodigo() == 1)
                atendentes.add(funcionarios.get(i));
        }
        return atendentes;
    }
    public ArrayList<Funcionario> getGerentes() {
        ArrayList<Funcionario> gerentes = new ArrayList<Funcionario>();
        for (int i=0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCodigo() == 1)
                gerentes.add(funcionarios.get(i));
        }
        return gerentes;
    }
}
