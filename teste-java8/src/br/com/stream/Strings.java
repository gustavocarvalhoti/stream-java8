package br.com.stream;

public class Strings {

    public static void main(String[] args) {

        /*
        String é a maneira errada de concatenar, ele vai criando varios objetos na memoria (As Strings são imutaveis)
        As Strings “antigas” perdem referência, mas continuam lá
        */
        String nameString = "Gustavo";
        nameString = nameString + " Carvalho" + " da Silva";
        System.out.println("String: " + nameString);

        /*
        A nossa string abaixo é um uso ideal para o operador '+',
        pois não estamos criando nenhum novo objeto em memória, apenas melhorando a legibilidade do código.
        */
        String strOK = "Gustavo " + "Carvalho " + "da Silva";
        System.out.println("String: " + strOK);

        /*
        StringBuilder é a maneira correta de concatenar strings
        Evita a criação de novos objetos String intermediários a cada concatenação, otimizando o desempenho.
        */
        StringBuilder nameStringBuilder = new StringBuilder("Gustavo");
        nameStringBuilder.append(" Carvalho");
        nameStringBuilder.append(" da Silva");
        System.out.println("StringBuilder: " + nameStringBuilder);

        /*
        StringBuffer é sincronizado, enquanto que o StringBuilder não.
        Assim, você garante a consistência do seu código quando há diversas threads lendo ou modificando a mesma String.
        Para esses casos, o ideal é usar o StringBuffer.
        O StringBuilder ainda é mais rápido do que o StringBuffer
        */
        StringBuffer nameStringBuffer = new StringBuffer("Gustavo");
        nameStringBuffer.append(" Carvalho");
        nameStringBuffer.append(" da Silva");
        System.out.println("StringBuffer: " + nameStringBuffer);
    }

}