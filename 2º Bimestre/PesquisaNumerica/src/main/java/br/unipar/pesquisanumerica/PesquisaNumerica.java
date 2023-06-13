/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.pesquisanumerica;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 00241269
 */
public class PesquisaNumerica {

    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos números você deseja cadastrar? ");
        int quantidade = scanner.nextInt();

        int[] numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Informe o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        Arrays.sort(numeros);

        System.out.println("Selecione o tipo de pesquisa:");
        System.out.println("1 - Pesquisa Linear");
        System.out.println("2 - Pesquisa Binária");
        int escolha = scanner.nextInt();

        System.out.print("Qual número você deseja pesquisar? ");
        int numeroPesquisado = scanner.nextInt();
        int posicao = -1;

        if (escolha == 1) {
            for (int i = 0; i < quantidade; i++) {
                if (numeros[i] == numeroPesquisado) {
                    posicao = i;
                    break;
                }
            }
        } else if (escolha == 2) {
            int inicio = 0;
            int fim = quantidade - 1;

            while (inicio <= fim) {
                int meio = (inicio + fim) / 2;

                if (numeros[meio] == numeroPesquisado) {
                    posicao = meio;
                    break;
                } else if (numeros[meio] < numeroPesquisado) {
                    inicio = meio + 1;
                } else {
                    fim = meio - 1;
                }
            }
        }

        if (posicao == -1) {
            System.out.println("O número " + numeroPesquisado + " não foi encontrado.");
        } else {
            System.out.println("O número " + numeroPesquisado + " foi encontrado na posição " + (posicao + 1) + ".");
        }
    }
}

