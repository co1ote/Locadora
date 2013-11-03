package locadora;

import java.util.Scanner;

public class Menu {
    
    public Scanner scan;
    
    public Menu() {
        scan = new Scanner(System.in);
    }
    
    public int menu() {
        int opcao;
        System.out.println("+----------------------------------------+");
        System.out.println("|   LOCADORA                             |");
        System.out.println("+----------------------------------------+");
        System.out.println("|        1 - Gerenciar carros            |");
        System.out.println("|        2 - Gerenciar clientes          |");
        System.out.println("|        3 - Gerenciar funcionários      |");
        System.out.println("|        4 - Gerenciar aluguéis          |");
        System.out.println("|        5 - Sair                        |");
        System.out.println("+----------------------------------------+");
        opcao = scan.nextInt();
        return opcao;
    }
    
    public int menuCarros() {
        int opcao;
        System.out.println("+----------------------------------------+");
        System.out.println("|   LOCADORA>CARROS                      |");
        System.out.println("+----------------------------------------+");
        System.out.println("|        1 - Novo carro                  |");
        System.out.println("|        2 - Excluir carro               |");
        System.out.println("|        3 - Editar carro                |");
        System.out.println("|        4 - Listar carros               |");
        System.out.println("|        5 - Voltar                      |");
        System.out.println("+----------------------------------------+");
        opcao = scan.nextInt();
        return opcao;
    }
    
    public int menuClientes() {
        int opcao;
        System.out.println("+----------------------------------------+");
        System.out.println("|   LOCADORA>CLIENTES                    |");
        System.out.println("+----------------------------------------+");
        System.out.println("|        1 - Novo cliente                |");
        System.out.println("|        2 - Excluir cliente             |");
        System.out.println("|        3 - Editar cliente              |");
        System.out.println("|        4 - Listar cliente              |");
        System.out.println("|        5 - Voltar                      |");
        System.out.println("+----------------------------------------+");
        opcao = scan.nextInt();
        return opcao;
    }
    
    public int menuFuncionario() {
        int opcao;
        System.out.println("+----------------------------------------+");
        System.out.println("|   LOCADORA>FUNCIONARIOS                |");
        System.out.println("+----------------------------------------+");
        System.out.println("|        1 - Atendente                   |");
        System.out.println("|        2 - Gerente                     |");
        System.out.println("|        3 - Listar funcionários         |");
        System.out.println("|        4 - Voltar                      |");
        System.out.println("+----------------------------------------+");
        opcao = scan.nextInt();
        return opcao;
    }
    
    public int menuAtendentes() {
        int opcao;
        System.out.println("+----------------------------------------+");
        System.out.println("|   LOCADORA>FUNCIONARIOS>ATENDENTES     |");
        System.out.println("+----------------------------------------+");
        System.out.println("|        1 - Novo atendente              |");
        System.out.println("|        2 - Demitir atendente           |");
        System.out.println("|        3 - Editar atendente            |");
        System.out.println("|        4 - Listar atendentes           |");
        System.out.println("|        5 - Adcionar vendas             |");
        System.out.println("|        6 - Voltar                      |");
        System.out.println("+----------------------------------------+");
        opcao = scan.nextInt();
        return opcao;
    }
    
    public int menuGerentes() {
        int opcao;
        System.out.println("+----------------------------------------+");
        System.out.println("|   LOCADORA>FUNCIONARIOS>GERENTES       |");
        System.out.println("+----------------------------------------+");
        System.out.println("|        1 - Novo gerente                |");
        System.out.println("|        2 - Demitir gerente             |");
        System.out.println("|        3 - Editar gerente              |");
        System.out.println("|        4 - Listar gerentes             |");
        System.out.println("|        5 - Adcionar horas extras       |");
        System.out.println("|        6 - Voltar                      |");
        System.out.println("+----------------------------------------+");
        opcao = scan.nextInt();
        return opcao;
    }
    
    public int menuAlugueis() {
        int opcao;
        System.out.println("+----------------------------------------+");
        System.out.println("|   LOCADORA>ALUGUEIS                    |");
        System.out.println("+----------------------------------------+");
        System.out.println("|        1 - Novo aluguel                |");
        System.out.println("|        2 - Finalizar aluguel           |");
        System.out.println("|        3 - Listar aluguéis             |");
        System.out.println("|        4 - Voltar                      |");
        System.out.println("+----------------------------------------+");
        opcao = scan.nextInt();
        return opcao;
    }
}
