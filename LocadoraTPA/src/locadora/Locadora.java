package locadora;

import java.util.ArrayList;
import negocio.Aluguel;
import negocio.Atendente;
import negocio.Carro;
import negocio.Cliente;
import negocio.Funcionario;
import negocio.Gerente;
import negocio.Loja;

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
                    loja.removerCarro(chassi);
                    break;
                case 3:
                    System.out.print("Digite o chassi :");
                    chassi = menu.scan.next();
                    if (loja.existeCarro(chassi)) {
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
                    } else
                        System.out.println("NÃO FOI ENCONTRADO");
                    break;
                case 4:
                    carros = loja.getCarros();
                    for (int i=0; i < carros.size(); i++) {
                        System.out.println(i);
                        System.out.println("Chassi: " + carros.get(i).getChassi());
                        System.out.println("Diaria: " + carros.get(i).getDiaria());
                        System.out.println("Alugado: " + carros.get(i).isAlugado());
                        System.out.println("Modelo: " + carros.get(i).getModelo());
                        System.out.println("Cor: " + carros.get(i).getCor());
                        System.out.println("Placa: " + carros.get(i).getPlaca());
                        System.out.println("Ano: " + carros.get(i).getAno());
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
                    loja.removerCliente(cpf);
                    break;
                case 3:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    if (loja.existeCliente(cpf)) {
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
                    } else
                        System.out.println("NÃO FOI ENCONTRADO");
                    break;
                case 4:
                    clientes = loja.getClientes();
                    for (int i=0; i < clientes.size(); i++) {
                        System.out.println(i);
                        System.out.println("Cpf: " + clientes.get(i).getCpf());
                        System.out.println("Nome: " + clientes.get(i).getNome());
                        System.out.println("Telefone: " + clientes.get(i).getTelefone());
                        System.out.println("Endereço: " + clientes.get(i).getEndereco());
                        System.out.println("Ano CNH: " + clientes.get(i).getAnoCNH());
                        System.out.println("Ano validade CNH: " + clientes.get(i).getAnoValidadeCNH());
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
    public static void gerenciarFuncionarios() {
        int opcao;
        String cpf;
        String nome;
        int anoCNH;
        int anoValidadeCNH;
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
                    for (int i=0; i < funcionarios.size(); i++) {
                        System.out.println(i);
                        System.out.println("Cpf : " +  funcionarios.get(i).getCpf());
                        System.out.println("Nome : " + funcionarios.get(i).getNome());
                        System.out.println("Salário base : + " + funcionarios.get(i).getSalario_base());
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
                    Cliente cliente = loja.getCliente(cpf);
                    if(cliente == null) 
                    {
                        System.out.print("ERRO 404");
                        menu.scan.next();
                        break;
                    }
                    
                    System.out.print("Digite o chassi: ");
                    chassi = menu.scan.next();
                    Carro carro = loja.getCarro(chassi);
                    if(carro == null){
                        System.out.print("ERRO 404");
                        menu.scan.next();
                        break;
                    }
                    System.out.print("Digite o dias: ");
                    dias = menu.scan.nextInt();
                    loja.adcionarLocacao(carro, cliente, dias);
                    break;
                case 2:
                    System.out.print("Digite o cpf: ");
                    cpf = menu.scan.next();
                    System.out.print("Digite o chassi: ");
                    chassi = menu.scan.next();  
                    if(!loja.existeAluguel(cpf, chassi)){
                        System.out.print("ERRO 404");
                        menu.scan.next();
                        break;
                    }
                    
                    loja.removerLocacao(cpf, chassi);
                    break;
                case 3:
                    ArrayList<Aluguel> locacoes = loja.getLocacoes();
                    for (int i=0; i < locacoes.size(); i++) {
                        System.out.println(i);
                        System.out.println("Cpf : " +  locacoes.get(i).getLocador().getCpf());
                        System.out.println("Chassi : " + locacoes.get(i).getCarro().getChassi());
                        System.out.println("Data de entrega : " + locacoes.get(i).getDataEntrega());
                        System.out.println("Valor total: " + locacoes.get(i).getValorTotal());
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
        int qnt_vendas;
        ArrayList<Funcionario> atendentes;
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
                    loja.removerFuncionario(cpf);
                    break;
                case 3:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    if (loja.existeFuncionario(cpf)) {
                        System.out.print("Digite o cpf :");
                        cpf = menu.scan.next();
                        System.out.print("Digite o nome :");
                        nome = menu.scan.next();
                        System.out.print("Digite a telefone :");
                        telefone = menu.scan.next();
                        System.out.print("Digite o salário base :");
                        salario_base = menu.scan.nextFloat();
                        loja.editarFuncionario(cpf, nome, telefone, salario_base);
                    } else
                        System.out.println("NÃO FOI ENCONTRADO");
                    break;
                case 4:
                    atendentes = loja.getAtendentes();
                    for (int i=0; i < atendentes.size(); i++) {
                        Atendente a = (Atendente)atendentes.get(i);
                        System.out.println(i);
                        System.out.println("Cpf: " + a.getCpf());
                        System.out.println("Nome: " + a.getNome());
                        System.out.println("Telefone: " + a.getTelefone());
                        System.out.println("Salário base: " + a.getSalario_base());
                        System.out.println("Salário : " + a.calculaGanho());
                        System.out.println("Qnt de vendas : " + a.getQnt_alugueis());
                    }
                    break;
                case 5:
                    System.out.println("Digite o cpf");
                    cpf = menu.scan.next();
                    atendentes = loja.getAtendentes();
                    for (int i=0; i < atendentes.size(); i++) {
                        Atendente a = (Atendente)atendentes.get(i);
                        if (a.getCpf().equals(cpf)) {
                            System.out.println("Digite o número de vendas");
                            qnt_vendas = menu.scan.nextInt();
                            a.adcionarVendas(qnt_vendas);
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
        ArrayList<Funcionario> gerentes;
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
                    loja.removerFuncionario(cpf);
                    break;
                case 3:
                    System.out.print("Digite o cpf :");
                    cpf = menu.scan.next();
                    if (loja.existeFuncionario(cpf)) {
                        System.out.print("Digite o cpf :");
                        cpf = menu.scan.next();
                        System.out.print("Digite o nome :");
                        nome = menu.scan.next();
                        System.out.print("Digite a telefone :");
                        telefone = menu.scan.next();
                        System.out.print("Digite o salário base :");
                        salario_base = menu.scan.nextFloat();
                        loja.editarFuncionario(cpf, nome, telefone, salario_base);
                    } else
                        System.out.println("NÃO FOI ENCONTRADO");
                    break;
                case 4:
                    gerentes = loja.getGerentes();
                    for (int i=0; i < gerentes.size(); i++) {
                        Gerente g = (Gerente)gerentes.get(i);
                        System.out.println(i);
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
                    for (int i=0; i < gerentes.size(); i++) {
                        Gerente g = (Gerente)gerentes.get(i);
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
