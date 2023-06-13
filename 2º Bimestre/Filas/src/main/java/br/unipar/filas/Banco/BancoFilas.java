/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Um banco necessita de uma sistema para controlar a fila de pagamentos no caixa. 
//Para o atendimento é obedecido a lei de prioridade, onde a cada 2 clientes prioritários, 
//um cliente normal é atendido. Desenvolva um algoritmo para controlar a fila de 
//atendimento, para isso deverá ser criado 2 filas, uma de atendimento prioritário e outra 
//de atendimento normal. Na fila será cadastrado os seguintes dados do cliente: 
//Cliente 
//- int senha; 
//- String nome; 
//- int anoNascimento; 
//Deverá ser determinado pela a idade qual fila será inserido o cliente, acima de 65 anos 
//fila prioritária, os demais na fila normal. Crie um menu com uma opção para adicionar o 
//cliente, e outra para chamar o cliente. Lembre-se deverá seguir a regra de ao ser 
//atendido 2 clientes prioritários será atendido um cliente normal.

package br.unipar.filas.Banco;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cliente {
    private int senha;
    private String nome;
    private int anoNascimento;

    public Cliente(int senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public int getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }
}

public class BancoFilas {
    private Queue<Cliente> filaPrioritaria;
    private Queue<Cliente> filaNormal;
    private int contadorPrioritarios;

    public BancoFilas() {
        filaPrioritaria = new LinkedList<>();
        filaNormal = new LinkedList<>();
        contadorPrioritarios = 0;
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente.getAnoNascimento() > 65) {
            filaPrioritaria.offer(cliente);
        } else {
            filaNormal.offer(cliente);
        }
        System.out.println("Cliente " + cliente.getNome() + " adicionado à fila.");
    }

    public void chamarCliente() {
        if (!filaPrioritaria.isEmpty()) {
            Cliente cliente = filaPrioritaria.poll();
            contadorPrioritarios++;
            System.out.println("Próximo cliente: " + cliente.getNome() + " (Prioritário)");
        } else if (!filaNormal.isEmpty() && contadorPrioritarios >= 2) {
            Cliente cliente = filaNormal.poll();
            contadorPrioritarios = 0;
            System.out.println("Próximo cliente: " + cliente.getNome());
        } else {
            System.out.println("A fila está vazia.");
        }
    }

    public static void main(String[] args) {
        BancoFilas filaAtendimento = new BancoFilas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Chamar próximo cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a senha do cliente: ");
                    int senha = scanner.nextInt();
                    System.out.print("Digite o nome do cliente: ");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String nome = scanner.nextLine();
                    System.out.print("Digite o ano de nascimento do cliente: ");
                    int anoNascimento = scanner.nextInt();
                    Cliente cliente = new Cliente(senha, nome, anoNascimento);
                    filaAtendimento.adicionarCliente(cliente);
                    break;
                case 2:
                    filaAtendimento.chamarCliente();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
