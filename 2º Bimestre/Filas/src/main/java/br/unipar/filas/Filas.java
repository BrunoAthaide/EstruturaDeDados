/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
////- Uma clínica precisa de um sistema para organizar a fila de pacientes, para cada dia 
//é disponibilizado 20 senhas para consulta. Eles necessitam de um sistema onde é 
//informado o nome do paciente em ordem de chegada e uma opção para chamar o 
//próximo paciente. Desenvolva um algoritmo de Fila, contendo um menu com as 
//opções: 1 - Adicionar paciente, 2 - Chamar próximo paciente. A opção 1 deverá exibir 
//um campo para informar o nome do paciente assim que ele chega no consultório, e a 
//opção 2, ao selecionar deverá exibir o nome do próximo paciente na fila.

package br.unipar.filas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Filas {
    private Queue<String> fila;

    public Filas() {
        fila = new LinkedList<>();
    }

    public void adicionarPaciente(String nome) {
        if (fila.size() < 20) {
            fila.offer(nome);
            System.out.println("Paciente " + nome + " adicionado à fila.");
        } else {
            System.out.println("A fila está cheia. Não é possível adicionar mais pacientes.");
        }
    }

    public void chamarProximoPaciente() {
        if (!fila.isEmpty()) {
            String proximoPaciente = fila.poll();
            System.out.println("Próximo paciente: " + proximoPaciente);
        } else {
            System.out.println("A fila está vazia.");
        }
    }

    public static void main(String[] args) {
        Filas filaClinica = new Filas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1 - Adicionar paciente-----");
            System.out.println("2 - Chamar próximo paciente-----");
            System.out.println("0 - Sair---");
            System.out.print("Escolha uma opção:-- ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String nomePaciente = scanner.nextLine();
                    filaClinica.adicionarPaciente(nomePaciente);
                    break;
                case 2:
                    filaClinica.chamarProximoPaciente();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.--------------");
            }
        }
    }
}
