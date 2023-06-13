/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// Desenvolva um método que mostre a sequência Fibonacci de um número. 
//Sequencia Fibonacci: 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 
//987, 1597, 2584, .
package br.unipar.recursividade.newpackage.ultima;
import javax.swing.JOptionPane;

public class Fibonacci {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um número:"));
        exibirSequenciaFibonacci(numero);
    }

    public static void exibirSequenciaFibonacci(int numero) {
        int numero1 = 0;
        int numero2 = 1;
        int proximoNumero = 0;

        String sequencia = "Sequência Fibonacci até " + numero + ":\n";
        sequencia += numero1 + ", " + numero2 + ", ";

        while (proximoNumero <= numero) {
            proximoNumero = numero1 + numero2;
            sequencia += proximoNumero + ", ";

            numero1 = numero2;
            numero2 = proximoNumero;
        }

        JOptionPane.showMessageDialog(null, sequencia);
    }
}

