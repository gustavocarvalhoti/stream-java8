package br.com.alura;

import java.util.function.Consumer;

public class ImprimeNaLinhaExterno implements Consumer<String> {
  @Override
  public void accept(String s) {
    System.out.println("ImprimeNaLinhaExterno -> " + s);
  }
}
