package EstagioRibeiraoPreto;

/*
https://github.com/RafaelGogge/estagio_home_office.git

2) Escreva um programa que verifique, em uma string, a existência da letra ‘a’, seja maiúscula ou minúscula, além de informar a quantidade de vezes em que ela ocorre.

IMPORTANTE: Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código; 

*/

import java.util.Scanner;

public class ContarLetraA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para verificar a letra 'a' (ou pressione Enter para usar a pré-definida): ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            input = "Exemplo de string para verificar a letra 'a'.";
        }

        int quantidade = contarLetraA(input);

        if (quantidade > 0) {
            System.out.println("A letra 'a' (ou 'A') existe na string e ocorre " + quantidade + " vez(es).");
        } else {
            System.out.println("A letra 'a' (ou 'A') não existe na string.");
        }
        scanner.close();
    }

    public static int contarLetraA(String str) {
        int contador = 0;

        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'A') {
                contador++;
            }
        }

        return contador;
    }
}
