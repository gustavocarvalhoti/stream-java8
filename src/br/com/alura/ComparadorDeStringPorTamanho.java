package br.com.alura;

import java.util.Comparator;

public class ComparadorDeStringPorTamanho implements Comparator<String> {
  //  Devolver um número negativo se o primeiro objeto for menor que o segundo
  public int compare(String s1, String s2) {
    if (s1.length() < s2.length()) {
      return -1;
    }
    if (s1.length() > s2.length()) {
      return 1;
    }
    return 0;
  }
}