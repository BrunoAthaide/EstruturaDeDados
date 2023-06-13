package br.unipar.SistemaContaBancaria;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class SistemaContaBancaria {
    private ContaBancaria[] contas;
    private int quantidadeContas;

    public SistemaContaBancaria(int capacidade) {
        contas = new ContaBancaria[capacidade];
        quantidadeContas = 0;
    }

    public void cadastrarConta(int numeroConta, String nomeTitular, double saldoInicial) {
        if (quantidadeContas < contas.length) {
            ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
            contas[quantidadeContas] = novaConta;
            quantidadeContas++;
            System.out.println("Conta cadastrada com sucesso!");
        } else {
            System.out.println("Não foi possível cadastrar a conta. Limite de contas atingido.");
        }
    }

    public void ordenarContas(String criterio) {
    switch (criterio.toLowerCase()) {
        case "numero":
            ordenarPorNumero();
            break;
        case "saldo":
            ordenarPorSaldo();
            break;
        default:
            System.out.println("Critério de ordenação inválido.");
            return;
    }
    System.out.println("Contas ordenadas com sucesso!");
    exibirContas();
}

private void ordenarPorNumero() {
    for (int i = 0; i < quantidadeContas - 1; i++) {
        int indiceMenor = i;
        for (int j = i + 1; j < quantidadeContas; j++) {
            if (contas[j].getNumeroConta() < contas[indiceMenor].getNumeroConta()) {
                indiceMenor = j;
            }
        }
        ContaBancaria temp = contas[i];
        contas[i] = contas[indiceMenor];
        contas[indiceMenor] = temp;
    }
}

private void ordenarPorSaldo() {
    for (int i = 0; i < quantidadeContas - 1; i++) {
        int indiceMenor = i;
        for (int j = i + 1; j < quantidadeContas; j++) {
            if (contas[j].getSaldo() < contas[indiceMenor].getSaldo()) {
                indiceMenor = j;
            }
        }
        ContaBancaria temp = contas[i];
        contas[i] = contas[indiceMenor];
        contas[indiceMenor] = temp;
    }
}


    public void depositar(int numeroConta, double valor) {
        for (int i = 0; i < quantidadeContas; i++) {
            if (contas[i].getNumeroConta() == numeroConta) {
                contas[i].adicionarDeposito(valor);
                System.out.println("Depósito realizado com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void sacar(int numeroConta, double valor) {
        ordenarContas("numero"); // Ordena as contas pelo número antes de realizar a pesquisa binária
        int index = buscaBinaria(numeroConta);
        if (index != -1) {
            contas[index].realizarSaque(valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private int buscaBinaria(int numeroConta) {
        int inicio = 0;
        int fim = quantidadeContas - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (contas[meio].getNumeroConta() == numeroConta) {
                return meio;
            } else if (contas[meio].getNumeroConta() < numeroConta) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    public double calcularSaldoTotal() {
        return calcularSaldoTotalRecursivo(0);
    }

    private double calcularSaldoTotalRecursivo(int index) {
        if (index == quantidadeContas) {
            return 0;
        } else {
            return contas[index].getSaldo() + calcularSaldoTotalRecursivo(index + 1);
        }
    }

    public void verificarSaldoNegativo() {
        verificarSaldoNegativoRecursivo(0);
    }

    private void verificarSaldoNegativoRecursivo(int index) {
        if (index == quantidadeContas) {
            return;
        } else {
            if (contas[index].getSaldo() < 0) {
                System.out.println("Conta com saldo negativo encontrada: ");
                System.out.println("Número da Conta: " + contas[index].getNumeroConta());
                System.out.println("Saldo R$  " + contas[index].getSaldo());
            }
            verificarSaldoNegativoRecursivo(index + 1);
        }
    }

    public void exibirContas() {
        if (quantidadeContas == 0) {
            System.out.println("Não há contas cadastradas !");
        } else {
            System.out.println("Contas cadastradas !");
            for (int i = 0; i < quantidadeContas; i++) {
                System.out.println(contas[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaContaBancaria sistema = new SistemaContaBancaria(10);

        int opcao = -1;
        while (opcao != 0) {
            
            System.out.println("=-=-=-=-=-==-=-=-=-=-==-=-=-=-=-==-=-=-=-=-==-=-=-=-=-=");
            System.out.println("=-=-=-=-=-=-=- Sistema de Conta Bancária =-=-=-=-=-=-=-");
            System.out.println("=-=-=-=-=-==-=-=-=-=-==-=-=-=-=-==-=-=-=-=-==-=-=-=-=-=");
            System.out.println("<< 1 >> Cadastrar conta.");
            System.out.println("<< 2 >> Ordenar contas.");
            System.out.println("<< 3 >> Realizar depósito.");
            System.out.println("<< 4 >> Realizar saque.");
            System.out.println("<< 5 >> Calcular saldo total.");
            System.out.println("<< 6 >> Verificar saldo negativo.");
            System.out.println("<< 0 >> Sair.");
            System.out.println("=-=-=-=-=-==-=-=-=-=-==-=-=-=-=-==-=-=-=-=-==-=-=-=-=-=");
            System.out.print("Digite a opção desejada: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    int numeroConta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do titular: ");
                    String nomeTitular = scanner.nextLine();
                    System.out.print("Saldo inicial R$ ");
                    double saldoInicial = scanner.nextDouble();
                    sistema.cadastrarConta(numeroConta, nomeTitular, saldoInicial);
                    break;
                case 2:
                    System.out.print("Defina o Critério de ordenação (numero ou saldo): ");
                    String criterio = scanner.next();
                    sistema.ordenarContas(criterio);
                    break;
                case 3:
                    System.out.print("Digite o número da conta ou o nome do titular: ");
                    scanner.nextLine();
                    String pesquisaDeposito = scanner.nextLine();
                    System.out.print("Valor do depósito R$ ");
                    double valorDeposito = scanner.nextDouble();
                    sistema.depositar(Integer.parseInt(pesquisaDeposito), valorDeposito);
                    break;
                case 4:
                    System.out.print("Número da conta: ");
                    int numeroContaSaque = scanner.nextInt();
                    System.out.print("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    sistema.sacar(numeroContaSaque, valorSaque);
                    break;
                case 5:
                    double saldoTotal = sistema.calcularSaldoTotal();
                    System.out.println("Saldo total do banco: " + saldoTotal);
                    break;
                case 6:
                    sistema.verificarSaldoNegativo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}
