package br.com.stream;

import br.com.stream.comparator.ComparatorStringLength;
import br.com.stream.model.Curso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class Ordenacao {

    public static void main(String[] args) {
        ordernarListas();
        orderArrayInteiro();
        orderByLength(Arrays.asList("Gustavo", "Michelle", "Duda", "Ana Maria Regina"));
        imprimeNaLinhaAcepted();
    }

    private static List<Curso> getCursos() {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 25", 113));
        cursos.add(new Curso("C", 55));
        return cursos;
    }

    private static void orderByLength(List<String> nomes) {
        System.out.println("\nNomes 01: ");
        nomes.forEach(System.out::println);

        // Ordena por length com lambda function do menor para o maior
        //nomes.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        nomes.sort(comparingInt(String::length));
        System.out.println("\nNomes 02: ");
        nomes.forEach(System.out::println);

        // Ordena por length com lambda function do maior para o menor
        nomes.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println("\nNomes 03: ");
        nomes.forEach(System.out::println);

        // Antes do Java8 (Não utilizar esse)
        // Ordena por length com lambda function do menor para o maior
        ComparatorStringLength comparador = new ComparatorStringLength();
        Collections.sort(nomes, comparador);
        System.out.println("\nNomes 04: ");
        nomes.forEach(System.out::println);

        // Top - Method reference - Ordena do menor para o maior
        //cursos.sort(Comparator.comparing(String::length));
        nomes.sort(comparing(String::length));
        System.out.println("\nNomes 05: ");
        nomes.forEach(System.out::println);

        // Lambda implicito - Method reference - Menor para maior
        nomes.forEach(System.out::println);
        System.out.println("\nNomes 06: ");
        nomes.forEach(System.out::println);

        // Imprime a primeira letra
        nomes.forEach(s -> System.out.println(s.substring(0, 1)));
        System.out.println("\nNomes 07: ");
        nomes.forEach(System.out::println);

        // Ordem alfabética
        nomes.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("\nNomes 08: ");
        nomes.forEach(System.out::println);
    }

    private static void ordernarListas() {
        // Ordena por numero de alunos
        List<Curso> cursos = getCursos();
        cursos.sort(comparingInt(Curso::getAlunos));
        //cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
        //cursos.sort(Comparator.comparingInt(Curso::getAlunos));

        // Filtra por cursos com mais de 100 alunos
        System.out.println("************************************************************************");
        Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
        streamDeCurso.forEach(c -> System.out.println(c.getNome() + " - " + c.getAlunos() + " alunos."));

        // Filtra por cursos com mais de 100 alunos e soma os alunos
        System.out.println("************************************************************************");
        System.out.print("Total de alunos: ");
        System.out.println(cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(Curso::getAlunos).sum());

        System.out.println("************************************************************************");
        cursos.forEach(c -> System.out.print(c.getAlunos() + " "));
        double media = cursos.stream().mapToInt(Curso::getAlunos).average().getAsDouble();
        System.out.print("/ " + cursos.size() + " = " + media + "\n");
        System.out.println("Média de alunos por cursos: " + (int) media);
    }

    // Ordenar lista de inteiros crescente
    private static void orderArrayInteiro() {
        int[] ints = {14, 37, -9, 102};
        var listaOrdenada = Arrays.stream(ints).sorted().toArray();
        System.out.println(Arrays.toString(listaOrdenada));
    }

    private static void imprimeNaLinhaAcepted() {
        List<String> palavras = Arrays.asList("casa do código", "caelum", "alura online", "z", "yz", "wxy");

        // Agora com o Java8 - Quando consume entra nesse cara, da para colocar externo tb
        // O Java 8 optou por criar um novo recurso que possibilitasse adicionar métodos em interfaces e implementá-los ali mesmo
        // Default method é um método de interface que você não precisa implementar na sua classe se não quiser,
        // pois você terá já essa implementação default
        System.out.println("*************************************************");
        class ImprimeNaLinha implements Consumer<String> {
            public void accept(String value) {
                System.out.println(value);
            }
        }
        //Consumer<String> consumidor = new ImprimeNaLinha();
        // Implementa o codigo acima e imprime

        // Ao chamar a classe ele imprime - Implementa uma classe externa
        Consumer<String> consumidor = new ImprimeNaLinhaExterno();
        palavras.forEach(consumidor);
        System.out.println(palavras);

        System.out.println("*************************************************");
        // Ordena a lista
        Collections.sort(palavras);
        System.out.println(palavras);
    }
}
