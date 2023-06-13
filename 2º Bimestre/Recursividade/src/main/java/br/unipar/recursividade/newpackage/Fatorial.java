/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Desenvolva um método que o usuário informe um número e calcule o fatorial 
//desse número. 
//Fórmula fatorial: n! = n . (n - 1)!
package br.unipar.recursividade.newpackage;

import javax.swing.JOptionPane;

public class Fatorial {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um número:"));
        long fatorial = calcularFatorial(numero);
        JOptionPane.showMessageDialog(null, "O fatorial de " + numero + " é: " + fatorial);
    }

    public static long calcularFatorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        } else {
            return numero * calcularFatorial(numero - 1);
        }
    }
}

