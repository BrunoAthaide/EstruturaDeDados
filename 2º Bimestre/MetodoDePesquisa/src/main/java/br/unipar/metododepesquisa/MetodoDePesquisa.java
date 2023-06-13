/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//Desenvolva um programa que solicite ao
//usuário para informar a quantidade de números
//que irá cadastrar, após solicite para informar os
//mesmos. Nesse aplicativo deverá ter um menu
//para selecionar o tipo de pesquisa que deseja
//fazer, linear ou binária. Para efetuar a pesquisa
//solicite qual número a ser pesquisado, coloque-os
//em ordem crescente e faça a pesquisa seleciona e
//exiba para o usuário o resultado
package br.unipar.metododepesquisa;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class MetodoDePesquisa {
    private int[] numeros;

    public void cadastrarNumeros(int quantidade) {
        numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            String input = JOptionPane.showInputDialog("Informe o número " + (i + 1) + ":");
            numeros[i] = Integer.parseInt(input);
        }

        Arrays.sort(numeros);
        JOptionPane.showMessageDialog(null, "Números cadastrados : " + Arrays.toString(numeros));
    }

    public int pesquisaLinear(int numero) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisaBinaria(int numero) {
        int inicio = 0;
        int fim = numeros.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (numeros[meio] == numero) {
                return meio;
            } else if (numeros[meio] < numero) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MetodoDePesquisa pesquisaNumeros = new MetodoDePesquisa();

        String quantidadeInput = JOptionPane.showInputDialog("Informe a quantidade de números a cadastrar:");
        int quantidade = Integer.parseInt(quantidadeInput);
        pesquisaNumeros.cadastrarNumeros(quantidade);

        while (true) {
            String opcaoInput = JOptionPane.showInputDialog(
                "MENU\n" +
                "1 - Pesquisa linear\n" +
                "2 - Pesquisa binária\n" +
                "0 - Sair\n" +
                "Escolha uma opção:"
            );
            int opcao = Integer.parseInt(opcaoInput);

            switch (opcao) {
                case 1:
                    String numeroLinearInput = JOptionPane.showInputDialog("Informe o número a pesquisar:------");
                    int numeroLinear = Integer.parseInt(numeroLinearInput);
                    int resultadoLinear = pesquisaNumeros.pesquisaLinear(numeroLinear);
                    if (resultadoLinear != -1) {
                        JOptionPane.showMessageDialog(null,
                            "O número " + numeroLinear + " foi encontrado na posição " + resultadoLinear);
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "O número " + numeroLinear + " não foi encontrado.");
                    }
                    break;
                case 2:
                    String numeroBinarioInput = JOptionPane.showInputDialog("Informe o número a pesquisar:---------");
                    int numeroBinario = Integer.parseInt(numeroBinarioInput);
                    int resultadoBinario = pesquisaNumeros.pesquisaBinaria(numeroBinario);
                    if (resultadoBinario != -1) {
                        JOptionPane.showMessageDialog(null,
                            "O número " + numeroBinario + " foi encontrado na posição " + resultadoBinario);
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "O número " + numeroBinario + " não foi encontrado.");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.!!!!!!!!!!!!");
            }
        }
    }
}

