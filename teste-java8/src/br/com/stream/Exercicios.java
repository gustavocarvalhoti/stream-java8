package br.com.stream;

import java.util.Arrays;

public class Exercicios {

    public static void main(String[] args) {
        verifyArrayContainsSum();
        //multiplos3e5();
    }

    private static void verifyArrayContainsSum() {
        // Dado o input abaixo:
        // int list[1,2,3,4]
        // int valor = 4
        // Verificar qual valor somado da 5 e exibir a posição do array
        // Saida: [0,2] R: Somando 1 + 3 = 4 (Imprimir a posição 0 e 2 conforme a resposta)

        int valor = 11;
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int position = 0; position < list.length; position++) {
            for (int otherPosition = (position + 1); otherPosition < list.length; otherPosition++) {
                if (list[position] + list[otherPosition] == valor) {
                    System.out.println("Valor encontrado: " + valor);
                    System.out.println(Arrays.asList(position, otherPosition));
                    break;
                }
            }
        }
    }


    private static void multiplos3e5() {
        /*
        Faça um código que imprima numeros de 1 a 30,
        Caso o número seja múltiplo de 3                    > Imprima Fizz
        Caso o número seja múltiplo de 5                    > Imprima Buzz
        Caso o número seja múltiplo de 3 e 5                > Imprima Fizz Buzz
        Caso o número não seja múltiplo nem de 3 nem de 5   > imprima o pŕoprio número (ex: 2)
        Output:
        1
        2
        Fizz
        4
        Buzz
        Fizz
        7
        8
        Fizz
        Buzz
        11
        Fizz
        13
        14
        FizzBuzz
        */

        for (int i = 1; i <= 30; i++) {
            String result = String.valueOf(i);
            // Multiplo de 3 = "Fizz"
            if (i % 3 == 0) {
                System.out.printf("(N:" + i + ") ");
                result = "Fizz";
            }
            // Multiplo de 5 = "Buzz"
            if (i % 5 == 0) {
                System.out.printf("(N:" + i + ") ");
                result = result.equals("Fizz") ? "FizzBuzz" : "Buzz";
            }

            System.out.println(result);
        }
    }
}
