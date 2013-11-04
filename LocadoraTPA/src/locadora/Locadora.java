package locadora;

import java.util.ArrayList;
import negocio.Aluguel;
import negocio.Atendente;
import negocio.Carro;
import negocio.Cliente;
import negocio.Funcionario;
import negocio.Gerente;
import negocio.Loja;
import negocio.NaoEncontradoException;

public class Locadora {
    public static Menu menu;
    public static Loja loja;
    
    public static void main(String[] args) {
        int opcao;
        menu = new Menu();
        loja = new Loja();
        
        while (true) {
            opcao = menu.menu();
            switch (opcao) {
                case 1:
                    gerenciarCarros();
                    break;
                case 2:
                    gerenciarClientes();
                    break;
                case 3:
                    gerenciarFuncionarios();
                    break;
                case 4:
                    gerenciarAlugueis();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
    
    public static void gerenciarCarros() {
        int opcao;
        String chassi, cor, modelo, placa;
        float diaria;
        int ano;
        ArrayList<Carro> carros;
        while (true) {
            opcao = menu.menuCarros();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o chassi :");
                    chassi = menu.scan.next();
                    System.out.print("Digite a diária :");
                    diaria = menu.scan.nextFloat();
                    Carro carro = new Carro(chassi, diaria);
                    loja.adcionarCarro(carro);
                    break;
                case 2:
                    System.out.print("Digite o chassi :");
                    chassi = menu.scan.next();
                    try {
                        loja.existeCarro(chassi);
                        loja.removerCarro(chassi);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Carro");
                    }
                    break;
                case 3:
                    System.out.print("Digite o chassi :");
                    chassi = menu.scan.next();
                    try {
                        loja.existeCarro(chassi);
                        System.out.print("Digite o chassi :");
                        chassi = menu.scan.next();
                        System.out.print("Digite o modelo :");
                        modelo = menu.scan.next();
                        System.out.print("Digite a cor :");
                        cor = menu.scan.next();
                        System.out.print("Digite a placa :");
                        placa = menu.scan.next();
                        System.out.print("Digite a diaria :");
                        diaria = menu.scan.nextFloat();
                        System.out.print("Digite o ano :");
                        ano = menu.scan.nextInt();
                        loja.editarCarro(chassi, diaria, cor, modelo, placa, ano);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Carro");
                    }
                    break;
                case 4:
                    carros = loja.getCarros();
                    for (Carro c : carros) {
                        System.out.println("Chassi: " + c.getChassi());
                        System.out.println("Diaria: " + c.getDiaria());
                        System.out.println("Alugado: " + c.isAlugado());
                        System.out.println("Modelo: " + c.getModelo());
                        System.out.println("Cor: " + c.getCor());
                        System.out.println("Placa: " + c.getPlaca());
                        System.out.println("Ano: " + c.getAno());
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
    public static void gerenciarClientes() {
        int opcao;
        String nome;
        String cpf;
        String telefone;
        String endereco;
        int anoCNH;
        int anoValidadeCNH;
        ArrayList<Cliente> clientes;
        while (true) {
            opcao = menu.menuClientes();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    System.out.print("Digite o nome :");
                    nome = menu.scan.next();
                    System.out.print("Digite o ano da CNH :");
                    anoCNH = menu.scan.nextInt();
                    System.out.print("Digite o ano da validade da CNH :");
                    anoValidadeCNH = menu.scan.nextInt();
                    Cliente cliente = new Cliente(nome, cpf, anoCNH, anoValidadeCNH);
                    loja.adcionarCliente(cliente);
                    break;
                case 2:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    try {
                        loja.existeCliente(cpf);
                        loja.removerCliente(cpf);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Cliente");
                    }
                    break;
                case 3:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    try {
                        loja.existeCliente(cpf);
                        System.out.print("Digite o cpf :");
                        cpf = menu.scan.next();
                        System.out.print("Digite o nome :");
                        nome = menu.scan.next();
                        System.out.print("Digite a telefone :");
                        telefone = menu.scan.next();
                        System.out.print("Digite a endereço :");
                        endereco = menu.scan.next();
                        System.out.print("Digite o ano da CNH :");
                        anoCNH = menu.scan.nextInt();
                        System.out.print("Digite o ano de validade da CNH :");
                        anoValidadeCNH = menu.scan.nextInt();
                        loja.editarCliente(cpf, nome, telefone, endereco, anoCNH, anoValidadeCNH);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Cliente");
                    }
                    break;
                case 4:
                    clientes = loja.getClientes();
                    for (Cliente c : clientes) {
                        System.out.println("Cpf: " + c.getCpf());
                        System.out.println("Nome: " + c.getNome());
                        System.out.println("Telefone: " + c.getTelefone());
                        System.out.println("Endereço: " + c.getEndereco());
                        System.out.println("Ano CNH: " + c.getAnoCNH());
                        System.out.println("Ano validade CNH: " + c.getAnoValidadeCNH());
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
    public static void gerenciarFuncionarios() {
        int opcao;
        ArrayList<Funcionario> funcionarios;
        while (true) {
            opcao = menu.menuFuncionario();
            switch(opcao) {
                case 1:
                    gerenciarAtendente();
                    break;
                case 2:
                    gerenciarGerente();
                    break;
                case 3:
                    funcionarios = loja.getFuncionarios();
                    for (Funcionario f : funcionarios) {
                        System.out.println("Cpf : " +  f.getCpf());
                        System.out.println("Nome : " + f.getNome());
                        System.out.println("Salário base : " + f.getSalario_base());
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
    public static void gerenciarAlugueis() {
        int opcao;
        
        while (true) {
            opcao = menu.menuAlugueis();
            String cpf;
            String chassi;
            int dias;
            switch(opcao) {
                case 1:
                    System.out.print("Digite o cpf: ");
                    cpf = menu.scan.next();
                    Cliente cliente;
                    try {
                        loja.existeCliente(cpf);
                        cliente = loja.getCliente(cpf);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Cliente");
                        break;
                    }
                    
                    System.out.print("Digite o chassi: ");
                    chassi = menu.scan.next();
                    Carro carro;
                    try {
                        loja.existeCarro(chassi);
                        carro = loja.getCarro(chassi);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Carro");
                        break;
                    }
                    
                    System.out.print("Digite o dias: ");
                    dias = menu.scan.nextInt();
                    try {
                        loja.naoExisteAluguel(cpf, chassi);
                        loja.adcionarLocacao(carro, cliente, dias);
                    } catch (NaoEncontradoException ex) {
                        System.out.println("Já existe aluguel");
                    }
                    break;
                case 2:
                    System.out.print("Digite o cpf: ");
                    cpf = menu.scan.next();
                    System.out.print("Digite o chassi: ");
                    chassi = menu.scan.next();  
                    try {
                        loja.naoExisteAluguel(cpf, chassi);
                        System.out.println("Não existe aluguel");
                    } catch (NaoEncontradoException ex) {
                        loja.removerLocacao(cpf, chassi);
                    }
                    break;
                case 3:
                    ArrayList<Aluguel> locacoes = loja.getLocacoes();
                    for (Aluguel l : locacoes) {
                        System.out.println("Cpf : " +  l.getLocador().getCpf());
                        System.out.println("Chassi : " + l.getCarro().getChassi());
                        System.out.println("Data de entrega : " + l.getDataEntrega());
                        System.out.println("Valor total: " + l.getValorTotal());
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
    public static void gerenciarAtendente() {
        int opcao;
        String nome;
        String cpf;
        String telefone;
        float salario_base;
        int qnt_alugueis;
        ArrayList<Atendente> atendentes;
        while (true) {
            opcao = menu.menuAtendentes();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    System.out.print("Digite o nome :");
                    nome = menu.scan.next();
                    System.out.print("Digite o salario base :");
                    salario_base = menu.scan.nextFloat();
                    Atendente atendente = new Atendente(cpf, nome, salario_base);
                    loja.adcionarFuncionario(atendente);
                    break;
                case 2:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    try {
                        loja.existeFuncionario(cpf);
                        loja.removerFuncionario(cpf);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Atendente");
                    }
                    break;
                case 3:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    try {
                        loja.existeFuncionario(cpf);
                        System.out.print("Digite o cpf :");
                        cpf = menu.scan.next();
                        System.out.print("Digite o nome :");
                        nome = menu.scan.next();
                        System.out.print("Digite a telefone :");
                        telefone = menu.scan.next();
                        System.out.print("Digite o salário base :");
                        salario_base = menu.scan.nextFloat();
                        loja.editarFuncionario(cpf, nome, telefone, salario_base);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Atendente");
                    }
                    break;
                case 4:
                    atendentes = loja.getAtendentes();
                    for (Atendente a : atendentes) {
                        System.out.println("Cpf: " + a.getCpf());
                        System.out.println("Nome: " + a.getNome());
                        System.out.println("Telefone: " + a.getTelefone());
                        System.out.println("Salário base: " + a.getSalario_base());
                        System.out.println("Salário : " + a.calculaGanho());
                        System.out.println("Qnt de aluguéis : " + a.getQnt_alugueis());
                    }
                    break;
                case 5:
                    System.out.println("Digite o cpf");
                    cpf = menu.scan.next();
                    atendentes = loja.getAtendentes();
                    for (Atendente a : atendentes) {
                        if (a.getCpf().equals(cpf)) {
                            System.out.println("Digite o número de vendas");
                            qnt_alugueis = menu.scan.nextInt();
                            a.adcionarAluguel(qnt_alugueis);
                        }
                    }
                    break;
                case 6:
                    return;
            }
        }
    }
    public static void gerenciarGerente() {
        int opcao;
        String nome;
        String cpf;
        String telefone;
        float salario_base;
        int banco_horas;
        ArrayList<Gerente> gerentes;
        while (true) {
            opcao = menu.menuGerentes();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    System.out.print("Digite o nome :");
                    nome = menu.scan.next();
                    System.out.print("Digite o salario base :");
                    salario_base = menu.scan.nextFloat();
                    Gerente gerente = new Gerente(cpf, nome, salario_base);
                    loja.adcionarFuncionario(gerente);
                    break;
                case 2:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    try {
                        loja.existeFuncionario(cpf);
                        loja.removerFuncionario(cpf);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Gerente");
                    }
                    break;
                case 3:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    try {
                        loja.existeFuncionario(cpf);
                        System.out.print("Digite o cpf :");
                        cpf = menu.scan.next();
                        System.out.print("Digite o nome :");
                        nome = menu.scan.next();
                        System.out.print("Digite a telefone :");
                        telefone = menu.scan.next();
                        System.out.print("Digite o salário base :");
                        salario_base = menu.scan.nextFloat();
                        loja.editarFuncionario(cpf, nome, telefone, salario_base);
                    } catch (NaoEncontradoException ex) {
                        System.out.println(ex + ": Gerente");
                    }
                    break;
                case 4:
                    gerentes = loja.getGerentes();
                    for (Gerente g : gerentes) {
                        System.out.println("Cpf: " + g.getCpf());
                        System.out.println("Nome: " + g.getNome());
                        System.out.println("Telefone: " + g.getTelefone());
                        System.out.println("Salário base: " + g.getSalario_base());
                        System.out.println("Salário : " + g.calculaGanho());
                        System.out.println("Banco de horas : " + g.getBanco_horas());
                    }
                    break;
                case 5:
                    System.out.println("Digite o cpf");
                    cpf = menu.scan.next();
                    gerentes = loja.getGerentes();
                    for (Gerente g : gerentes) {
                        if (g.getCpf().equals(cpf)) {
                            System.out.println("Digite o número de horas extras");
                            banco_horas = menu.scan.nextInt();
                            g.adcionarHoras(banco_horas);
                        }
                    }
                    break;
                case 6:
                    return;
            }
        }
    }
}
