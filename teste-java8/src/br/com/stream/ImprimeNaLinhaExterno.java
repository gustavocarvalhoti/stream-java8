package br.com.stream;

import java.util.function.Consumer;

public class ImprimeNaLinhaExterno implements Consumer<String> {
    // Ao chamar a classe ele imprime
    @Override
    public void accept(String value) {
        System.out.println("ImprimeNaLinhaExterno -> " + value);
    }
}
