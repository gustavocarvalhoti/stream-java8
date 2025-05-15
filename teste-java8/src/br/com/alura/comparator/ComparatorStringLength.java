package br.com.alura.comparator;

import java.util.Comparator;

public class ComparatorStringLength implements Comparator<String> {
    //  Devolver um número negativo se o primeiro objeto for menor que o segundo
    public int compare(String s1, String s2) {
        return s1.length() < s2.length() ? -1 : 1;
    }
}