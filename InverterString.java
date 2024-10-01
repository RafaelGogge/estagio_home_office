/*
https://github.com/RafaelGogge/estagio_home_office.git

5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;

*/


import java.util.Scanner;

public class InverterString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para inverter (ou pressione Enter para usar a pré-definida): ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            input = "Exemplo de string a ser invertida!";
        }

        String invertedString = inverter(input);

        System.out.println("String original: " + input);
        System.out.println("String invertida: " + invertedString);

        scanner.close();

    }

    public static String inverter(String str) {
        StringBuilder inverted = new StringBuilder();
        int length = str.length();

        // Percorre a string de trás para frente
        for (int i = length - 1; i >= 0; i--) {
            inverted.append(str.charAt(i)); 
        }

        return inverted.toString();
    }
}
