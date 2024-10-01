/*
https://github.com/RafaelGogge/estagio_home_office.git

2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

*/

import java.util.Scanner;

public class FibonacciCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para verificar se pertence à sequência de Fibonacci: ");

        int numero = scanner.nextInt();

        int a = 0, b = 1, proximo = 0;

        if (numero == a || numero == b) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            while (proximo < numero) {
                proximo = a + b;
                a = b;
                b = proximo;
            }

            if (proximo == numero) {
                System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
            }
        }

        scanner.close();
    }
}
