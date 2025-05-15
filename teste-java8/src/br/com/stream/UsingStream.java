package br.com.stream;

import br.com.stream.model.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingStream {

    private static List<Pessoa> listaPessoas = Arrays.asList(
            new Pessoa("Joao", 32),
            new Pessoa("Antonio", 20),
            new Pessoa("Maria", 18),
            new Pessoa("Gustavo", 18),
            new Pessoa("Angela", 30)
    );

    public static void main(String[] args) {
        //ex01();
        //ex02();
        //ex03();
        //ex04();
        //ex05();
        //ex06();
        //ex07();
        //orderArrayInteiro();
    }

    // Ordenar lista de inteiros crescente
    private static void orderArrayInteiro() {
        int[] ints = {14, 37, -9, 102};
        var listaOrdenada = Arrays.stream(ints).sorted().toArray();

        // Verifica se possui um inteiro com esse valor
        var result = Arrays.stream(ints).anyMatch(value -> value == 15);
        System.out.println(result);

        System.out.println(Arrays.toString(listaOrdenada));
    }

    // Cria um map to int e soma os valores
    public static void ex01() {
        Stream<Pessoa> streamPessoas = listaPessoas.stream();
        int sum = streamPessoas
                .filter(p -> p.getNome().startsWith("A"))
                .mapToInt(Pessoa::getIdade)
                .sum();
        System.out.println("Soma da idade das pessoas que o nome começa com A: " + sum);
    }

    // Descobre o maximo
    // Descobre o minimo
    private static void ex02() {
        int maiorIdadde = listaPessoas.stream()
                .mapToInt(Pessoa::getIdade)
                .max()
                .getAsInt();

        int menorIdade = listaPessoas.stream()
                .mapToInt(Pessoa::getIdade)
                .min()
                .getAsInt();

        System.out.println("Maior idade: " + maiorIdadde);
        System.out.println("Menor idade: " + menorIdade);
    }

    // Soma, Max e Min
    private static void ex03() {
        IntSummaryStatistics intSummStat = listaPessoas
                .stream()
                //.filter(p -> p.getNome().startsWith("A"))
                .mapToInt(Pessoa::getIdade)
                .summaryStatistics();

        System.out.println("Soma das idades: " + intSummStat.getSum());
        System.out.println("Maior idade: " + intSummStat.getMax());
        System.out.println("Menor idade: " + intSummStat.getMin());
    }

    // Media
    private static void ex04() {
        double average = listaPessoas
                .stream()
                .mapToInt(Pessoa::getIdade)
                .average()
                .getAsDouble();

        System.out.println("Média de idades: " + average);
    }

    // Filtra as pessoas que o nome começã com A
    // Da o exemplo de Set, pode utilizar list tb
    private static void ex05() {
        List<Pessoa> listPessoasFiltrada = listaPessoas
                .stream()
                .filter(p -> p.getNome().startsWith("A"))
                .toList();

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

    // Agrupa as pessoas por idade
    private static void ex06() {
        Map<Integer, List<Pessoa>> map = listaPessoas
                .stream()
                .collect(Collectors.groupingBy(Pessoa::getIdade));

        // Exibe as pessoas com 18 anos
        map.get(18).forEach(p -> System.out.println("Pessoa com 18 anos: " + p.getNome()));
    }

    // Pessoa maior de 18
    // Verifica e pega a primeira
    private static void ex07() {
        var optPessoa = listaPessoas
                .stream()
                .filter(p -> p.getIdade() > 20)
                .findFirst();

        if (optPessoa.isEmpty()) {
            optPessoa = Optional.of(new Pessoa("Duda", 10));
        }

        optPessoa.ifPresent(p -> System.out.println(p.getNome() + " - " + p.getIdade()));
    }

    // Verificar se existe no array de inteiros
    private static void existeNoArray() {
        int number = 2;
        int[] listNumbers = {2, 3, 1};
        var result = Arrays.stream(listNumbers)
                .filter(n -> n == number).findAny().isPresent() ? "YES" : "NO";
        System.out.println(result);
    }

    // Numeros impares
    private static void numerosImparesDeAte(int nInicial, int nFinal) {
        int position = 0;
        int[] listFull = new int[(nFinal - nInicial) + 1];
        for (int i = nInicial; i <= nFinal; i++) {
            listFull[position] = i;
            position++;
        }

        int[] listFiltered = Arrays.stream(listFull).filter(n -> n % 2 != 0).toArray();
        Arrays.stream(listFiltered).forEach(System.out::println);
    }

    // Arredondamento para cima
    private static void arredondamento() {
        double d = 12.548795;
        // RoundingMode.HALF_EVEN -> Arredonda para cima
        BigDecimal bd = new BigDecimal(d).setScale(3, RoundingMode.HALF_EVEN);
        System.out.println(bd.doubleValue());
    }

}