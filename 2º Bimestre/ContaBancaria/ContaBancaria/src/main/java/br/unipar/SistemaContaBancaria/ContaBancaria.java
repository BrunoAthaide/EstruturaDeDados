package br.unipar.SistemaContaBancaria;

import java.util.Comparator;

public class ContaBancaria {
    
    private int numeroConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(int numeroConta, String nomeTitular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarDeposito(double valor) {
        saldo += valor;
    }

    public void realizarSaque(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }

   
      @Override
    public String toString() {
        return "Número da Conta: " + numeroConta + ", Titular: " + nomeTitular + ", Saldo: " + saldo;
    }
    class ComparadorContaNumero implements Comparator<ContaBancaria> {
    
    @Override
    public int compare(ContaBancaria conta1, ContaBancaria conta2) {
        return Integer.compare(conta1.getNumeroConta(), conta2.getNumeroConta());
    }
}

    class ComparadorContaSaldo implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria conta1, ContaBancaria conta2) {
        return Double.compare(conta1.getSaldo(), conta2.getSaldo());
    }
}
    
}