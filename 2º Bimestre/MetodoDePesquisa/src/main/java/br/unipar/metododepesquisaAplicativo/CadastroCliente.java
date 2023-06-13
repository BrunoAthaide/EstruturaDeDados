/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
////// */
//Crie um aplicativo de cadastro de clientes
//deve-se armazenar o código, Nome, data de
//nascimento e cpf. Faça com que o usuário informe
//esses dados, o aplicativo deverá ordenar os
//clientes pelo código. Faça com que o aplicativo
//solicite ao usuário informar o código do cliente
//efetue uma pesquisa binária para localizar o
//cliente e exibir na tela os seus dados
package br.unipar.metododepesquisaAplicativo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

class Cliente {
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Cliente(int codigo, String nome, String dataNascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
}

class ClienteComparator implements Comparator<Cliente> {
    @Override
    public int compare(Cliente c1, Cliente c2) {
        return Integer.compare(c1.getCodigo(), c2.getCodigo());
    }
}

public class CadastroCliente {
    private ArrayList<Cliente> clientes;

    public CadastroCliente() {
        clientes = new ArrayList<>();
    }

    public void cadastrarCliente() {
        String codigoInput = JOptionPane.showInputDialog("Informe o código do cliente:");
        int codigo = Integer.parseInt(codigoInput);
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente:");
        String dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento do cliente:");
        String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente:");

        Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
        clientes.add(cliente);
        Collections.sort(clientes, new ClienteComparator());

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }

    public void pesquisarCliente() {
        String codigoInput = JOptionPane.showInputDialog("Informe o código do cliente a pesquisar:");
        int codigoPesquisa = Integer.parseInt(codigoInput);

        int indice = pesquisaBinaria(codigoPesquisa);

        if (indice != -1) {
            Cliente cliente = clientes.get(indice);
            String mensagem = "Código: " + cliente.getCodigo() +
                    "\nNome: " + cliente.getNome() +
                    "\nData de Nascimento: " + cliente.getDataNascimento() +
                    "\nCPF: " + cliente.getCpf();

            JOptionPane.showMessageDialog(null, mensagem);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    private int pesquisaBinaria(int codigoPesquisa) {
        int inicio = 0;
        int fim = clientes.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Cliente cliente = clientes.get(meio);

            if (cliente.getCodigo() == codigoPesquisa) {
                return meio;
            } else if (cliente.getCodigo() < codigoPesquisa) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CadastroCliente cadastro = new CadastroCliente();

        while (true) {
            String opcaoInput = JOptionPane.showInputDialog(
                    "MENU\n" +
                            "1 - Cadastrar cliente\n" +
                            "2 - Pesquisar cliente\n" +
                            "0 - Sair\n" +
                            "Escolha uma opção:"
            );
            int opcao = Integer.parseInt(opcaoInput);

            switch (opcao) {
                case 1:
                    cadastro.cadastrarCliente();
                    break;
                case 2:
                    cadastro.pesquisarCliente();
                    break;
                case 0:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }
}

