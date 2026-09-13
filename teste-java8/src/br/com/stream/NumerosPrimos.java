package br.com.stream;

public class NumerosPrimos {

    static void main() {
        numeroPrimo(10);
        numeroPrimo(11);
        numeroPrimo(12);
        numeroPrimo(13);
        numeroPrimo(14);
        numeroPrimo(15);
    }

    // Descobre por quais numeros são divisiveis
    // Ex: 15 divide por 3 e 5
    public static void numeroPrimo(int n) {
        System.out.print(n + " é divisivel por: ");

        StringBuilder result = new StringBuilder();
        for (int i = 2; i < n; i++) {
            // Numero divisivel
            if (n % i == 0) {
                if (result.isEmpty()) {
                    result.append(i);
                } else {
                    result.append(", ").append(i);
                }
            }
        }
        // Valida se não dividiu por nenhum numero
        if (result.isEmpty()) {
            result.append(n).append(" apenas (Numero primo)");
        }

        System.out.println(result);
    }
}