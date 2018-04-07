package br.com.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingStream {

    public static void main(String[] args) {
        ex01();
        ex02();
        ex03();
        ex04();
        ex05();
        ex06();
        ex07();
    }

    private static List<Pessoa> listaPessoas = Arrays.asList(
            new Pessoa("Joao", 32),
            new Pessoa("Antonio", 20),
            new Pessoa("Maria", 18),
            new Pessoa("Gustavo", 18),
            new Pessoa("Angela", 30)
    );

    public static void ex01() {
        Stream<Pessoa> streamPessoas = listaPessoas.stream();
        Integer sum = streamPessoas
                .filter(p -> p.getNome().startsWith("A"))
                .mapToInt(p -> p.getIdade())
                .sum();
        System.out.println("Soma da idade das pessoas que o nome começa com A: " + sum);
    }

    private static void ex02() {
        Integer maiorIdadde = listaPessoas.stream()
                .mapToInt(p -> p.getIdade())
                .max()
                .getAsInt();


        Integer menorIdade = listaPessoas.stream()
                .mapToInt(p -> p.getIdade())
                .min()
                .getAsInt();

        System.out.println("Maior idade: " + maiorIdadde);
        System.out.println("Menor idade: " + menorIdade);
    }

    private static void ex03() {
        IntSummaryStatistics intSummStat = listaPessoas
                .stream()
                //.filter(p -> p.getNome().startsWith("A"))
                .mapToInt(p -> p.getIdade())
                .summaryStatistics();

        System.out.println("Soma das idades: " + intSummStat.getSum());
        System.out.println("Maior idade: " + intSummStat.getMax());
        System.out.println("Menor idade: " + intSummStat.getMin());
    }

    private static void ex04() {
        Double average = listaPessoas
                .stream()
                .mapToInt(p -> p.getIdade())
                .average()
                .getAsDouble();

        System.out.println("Média de idades: " + average);
    }

    private static void ex05() {
        List<Pessoa> listPessoasFiltrada = listaPessoas
                .stream()
                .filter(p -> p.getNome().startsWith("A"))
                .collect(Collectors.toList());

        // Transforma a lista em set
        Set<Pessoa> setOfPessoas = listPessoasFiltrada
                .stream()
                .filter(p -> p.getNome().startsWith("A"))
                .collect(Collectors.toSet());

        Iterator<Pessoa> pessoaAsIterator = setOfPessoas.iterator();
        System.out.print("Pessoas com a letra A -> ");
        while (pessoaAsIterator.hasNext()) {
            System.out.print(pessoaAsIterator.next().getNome() + " | ");
        }
        System.out.println();
    }

    private static void ex06() {
        // Agrupa as pessoas por idade
        Map<Integer, List<Pessoa>> map = listaPessoas
                .stream()
                .collect(Collectors.groupingBy(Pessoa::getIdade));

        // Exibe as pessoas com 18 anos
        map.get(18).forEach(p -> System.out.println("Pessoa com 18 anos: " + p.getNome()));
    }

    private static void ex07() {
        Optional<Pessoa> optPessoa = listaPessoas
                .stream()
                .filter(p -> p.getIdade() > 20)
                .findFirst();

        if (!optPessoa.isPresent()) {
            optPessoa = Optional.of(new Pessoa("Banana", 1));
        }

        optPessoa.ifPresent(p -> System.out.println(p.getNome() + " - " + p.getIdade()));
    }
}