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
        dataEntrega.setTime(dataEntrega.getTime() + dias * 60 * 1000 * 60 * 24);
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
        for (Carro c : carros) {
            if (c.getChassi().equals(chassi)) {
                carros.remove(c);
                return "REMOVIDO";
            }
        }
        return "NÃO FOI ENCONTRADO";
    }

    public String removerCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                clientes.remove(c);
                return "REMOVIDO";
            }
        }
        return "NÃO FOI ENCONTRADO";
    }

    public String removerLocacao(String cpf, String chassi) {
        for (Aluguel a : locacoes) {
            if (a.getCarro().getChassi().equals(chassi) && a.getLocador().getCpf().equals(cpf)) {
                locacoes.remove(a);
                for (Carro c : carros) {
                    if (c.getChassi().equals(chassi)) {
                        c.setAlugado(false);
                    }
                }
                return "REMOVIDO";
            }
        }
        return "NÃO FOI ENCONTRADO";
    }

    public String removerFuncionario(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                funcionarios.remove(f);
                return "REMOVIDO";
            }
        }
        return "NÃO FOI ENCONTRADO";
    }

    public boolean existeCarro(String chassi) {
        for (Carro c : carros) {
            if (c.getChassi().equals(chassi)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeFuncionario(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeAluguel(String cpf, String chassi) {
        for (Aluguel a : locacoes) {
            if (a.getCarro().getChassi().equals(chassi) && a.getLocador().getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public String editarCarro(String chassi, float diaria, String cor, String modelo, String placa, int ano) {
        for (Carro c : carros) {
            if (c.getChassi().equals(chassi)) {
                c.setAno(ano);
                c.setChassi(chassi);
                c.setCor(cor);
                c.setModelo(modelo);
                c.setPlaca(placa);
                c.setDiaria(diaria);
                return "EDITADO COM SUCESSO";
            }
        }
        return "ERRO AO EDITAR";
    }

    public String editarCliente(String cpf, String nome, String telefone, String endereco, int anoCNH, int validadeCNH) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                c.setAnoValidadeCNH(validadeCNH);
                c.setAnoCNH(anoCNH);
                c.setEndereco(endereco);
                c.setTelefone(telefone);
                c.setNome(nome);
                c.setCpf(cpf);
                return "EDITADO COM SUCESSO";
            }
        }
        return "EDITADO COM SUCESSO";
    }

    public String editarFuncionario(String cpf, String nome, String telefone, float salario_base) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                f.setTelefone(telefone);
                f.setNome(nome);
                f.setCpf(cpf);
                return "EDITADO COM SUCESSO";
            }
        }
        return "EDITADO COM SUCESSO";
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public Carro getCarro(String chassi) {
        for (Carro c : carros) {
            if (c.getChassi().equals(chassi)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Aluguel> getLocacoes() {
        return locacoes;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Atendente> getAtendentes() {
        ArrayList<Atendente> atendentes = new ArrayList<Atendente>();
        for (Funcionario f : funcionarios) {
            if (f.getCodigo() == 1) {
                atendentes.add((Atendente) f);
            }
        }
        return atendentes;
    }

    public ArrayList<Gerente> getGerentes() {
        ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
        for (Funcionario f : funcionarios) {
            if (f.getCodigo() == 0) {
                gerentes.add((Gerente) f);
            }
        }
        return gerentes;
    }
}
