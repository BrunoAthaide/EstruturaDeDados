/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.recursividade;

import javax.swing.JOptionPane;

public class Recursividade {
    public static void main(String[] args) {
        int soma = calcularSoma(0, 50);
        JOptionPane.showMessageDialog(null, "A soma de 0 a 50 é: " + soma);
    }

    public static int calcularSoma(int inicio, int fim) {
        int soma = 0;
        for (int i = inicio; i <= fim; i++) {
            soma += i;
        }
        return soma;
    }
}
