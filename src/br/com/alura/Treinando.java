package br.com.alura;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Treinando {

  public static void main(String[] args) {
    defaultMethods();
  }

  private static void defaultMethods() {
    //test01();
    //test02();
    //orderByLength();
    ordernarListas();
    //findAny();
    //collect();
  }

  private static void collect() {
    List<Curso> cursos = getCursos();

    System.out.println("*************************************************************************************");
    List<Curso> resultados = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
    resultados.stream().forEach(c -> System.out.println(c.getNome()));

    // Map
    System.out.println("*************************************************************************************");
    // toMap(c -> c.getNome(), c -> c.getAlunos()) - Key and Value
    Map mapa = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
    mapa.keySet().stream().forEach(System.out::println);
    mapa.values().stream().forEach(System.out::println);
  }

  // Pega o primeiro que achar
  private static void findAny() {
    List<Curso> cursos = getCursos();
    Optional<Curso> optional = cursos.stream().filter(c -> c.getAlunos() > 100).findAny();

    // Se não trouxe nada da erro
    // Curso curso = optional.get();

    // Melhor usar esse - se não tem nada coloca null
    // Curso curso = optional.orElse(null);

    // Pode usar assim
    /*
    if (curso != null) {
      System.out.println(curso.getNome());
    }*/

    // Ou assim - Mais top
    optional.ifPresent(c -> System.out.println(c.getNome()));

    //Ou tudo junto tb
    cursos.stream().filter(c -> c.getAlunos() > 100).findAny().ifPresent(c -> System.out.println(c.getNome()));
  }

  private static List<Curso> getCursos() {
    List<Curso> cursos = new ArrayList<Curso>();
    cursos.add(new Curso("Python", 45));
    cursos.add(new Curso("JavaScript", 150));
    cursos.add(new Curso("Java 8", 113));
    cursos.add(new Curso("C", 55));
    return cursos;
  }

  private static void ordernarListas() {
    List<Curso> cursos = getCursos();

    //cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
    //cursos.sort(Comparator.comparingInt(Curso::getAlunos));
    cursos.sort(comparingInt(Curso::getAlunos));

    System.out.println("************************************************************************");
    Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
    streamDeCurso.forEach(c -> System.out.println(c.getAlunos()));

    System.out.println("************************************************************************");
    // Imprime o numero de alunos
    //cursos.stream().filter(c -> c.getAlunos() > 100).map(c -> c.getAlunos()).forEach(x -> System.out.println(x));
    //cursos.stream().filter(c -> c.getAlunos() > 100).map(c -> c.getAlunos()).forEach(System.out::println);
    //cursos.stream().filter(c -> c.getAlunos() > 100).map(Curso::getAlunos).forEach(System.out::println);
    // N]ao funciona para o filter
    cursos.stream().filter(c -> c.getAlunos() > 100).map(Curso::getAlunos).forEach(System.out::println);

    System.out.println("************************************************************************");
    System.out.println(cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(Curso::getAlunos).sum());

    System.out.println("************************************************************************");
    Stream<String> nomes = cursos.stream().map(Curso::getNome);
    nomes.forEach(System.out::println);

    System.out.println("************************************************************************");
    System.out.println("Média de alunos: " + cursos.stream().mapToInt(Curso::getAlunos).average().getAsDouble());
  }

  private static void orderByLength() {
    List<String> palavras = Arrays.asList("alura123456789", "caelum", "alura1", "Z", "yz", "wxy");
    //Comparator<String> comparador = Comparator.comparing(s -> s.length());
    //palavras.sort(comparador);

    // Top - Method reference
    //palavras.sort(Comparator.comparing(String::length));
    palavras.sort(comparing(String::length));

    // ForEach top
    //palavras.forEach(s -> System.out.println(s));
    // Lambda implicito - Method reference
    palavras.forEach(System.out::println);
    // Esse não funciona implicito
    palavras.forEach(s -> System.out.println(s.substring(0, 1)));

    // Letra maiuscula por ultimo
    palavras.sort(String.CASE_INSENSITIVE_ORDER);
    palavras.forEach(System.out::println);
  }

  private static void test01() {
    List<String> palavras = Arrays.asList("casa do código", "caelum", "alura online", "z", "yz", "wxy");

    // Agora com o Java8 - Quando consume entra nesse cara, da para colocar externo tb
    // O Java 8 optou por criar um novo recurso que possibilitasse adicionar métodos em interfaces e implementá-los ali mesmo
    // Default method é um método de interface que você não precisa implementar na sua classe se não quiser,
    // pois você terá já essa implementação default
    System.out.println("*************************************************");
    class ImprimeNaLinha implements Consumer<String> {
      public void accept(String s) {
        System.out.println(s);
      }
    }
    //Consumer<String> consumidor = new ImprimeNaLinha();
    Consumer<String> consumidor = new ImprimeNaLinhaExterno();
    palavras.forEach(consumidor);
    System.out.println(palavras);

    System.out.println("*************************************************");
    // Ordena a lista
    Collections.sort(palavras);
    System.out.println(palavras);

    orderByLength(palavras);
  }

  private static void orderByLength(List<String> palavras) {
    //Outra forma - melhor com lambda
    System.out.println("*************************************************");
    palavras.forEach(s -> System.out.println(s));
    System.out.println("*************************************************");
    // Ordena por length com lambda
    //palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
    // Do maior para o menor
    palavras.sort((s1, s2) -> s1.length() - s2.length());
    System.out.println(palavras);
    // Do menor para o maior
    palavras.sort((s1, s2) -> s2.length() - s1.length());
    System.out.println(palavras);

    // Antes do Java8
    // Retorna as palavra por ordem de tamanho
    //Comparator<String> comparador = new ComparadorDeStringPorTamanho();
    System.out.println("*************************************************");
    ComparadorDeStringPorTamanho comparador = new ComparadorDeStringPorTamanho();
    Collections.sort(palavras, comparador);
    System.out.println(palavras);
  }

  private static void test02() {
    // Normal
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Executando um Runnable");
      }
    }).start();

    // Lambda
    new Thread(() -> System.out.println("Executando um Runnable")).start();
  }
}
