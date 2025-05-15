package br.com.stream;

public class ExercicioFizzBuzzMultiplo3e5 {
    /*
    Faça um código que imprima numeros de 1 a 30,
    Caso o número seja múltiplo de 3 > Imprima Fizz
    Caso o número seja múltiplo de 5 > Imprima Buzz
    Caso o número seja múltiplo de 3 e 5 > Imprimza Fizz Buzz
    Pode ser junto, separado, com traço, tanto faz
    Caso o número não seja múltiplo nem de 3 nem de 5 > imprima o pŕoprio número (ex: 2)
    exemplo de saída
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

    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            // Não é multiplo
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i + "");
            }
            // Multiplo de 3
            if (i % 3 == 0) {
                System.out.print("Fizz");
            }
            // Multiplo de 5
            if (i % 5 == 0) {
                System.out.print("Buzz");
            }
            // Pular linha
            System.out.println();
        }
    }
}
