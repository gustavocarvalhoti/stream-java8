package br.com.stream;

import br.com.stream.model.Curso;

import java.util.*;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
        filterFindAny();
        filterAndMap();
    }

    private static List<Curso> getCursos() {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));
        return cursos;
    }

    private static void filterAndMap() {
        List<Curso> cursos = getCursos();

        System.out.println("*************************************************************************************");
        List<Curso> resultados = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .toList();
        // Imprime o nome do Curso
        resultados.forEach(c -> System.out.println(c.getNome()));

        // Map -
        System.out.println("*************************************************************************************");
        // HashMap<String, Integer> = JavaScript: 150
        Map mapa = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos));

        System.out.println("Cursos:" + mapa.keySet());
        System.out.println("Alunos:" + mapa.values());
    }

    // Pega o primeiro que achar utilizando filter
    private static void filterFindAny() {
        List<Curso> cursos = getCursos();
        Optional<Curso> cursoSelecionado = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .findAny();

        Optional<Curso> cursoNaoEncontrado = cursos.stream()
                .filter(c -> c.getAlunos() > 150)
                .findAny();

        // Se não trouxe nada da erro
        try {
            Curso curso1 = cursoNaoEncontrado.get();
        } catch (Exception e) {
            System.out.println("Erro esperado, curso não existe.");
        }

        // Melhor usar esse - se não tem nada coloca null
        Curso curso2 = cursoNaoEncontrado.orElse(null);
        if (Objects.isNull(curso2)) {
            System.out.println("Curso não encontrado");
        }

        // Ou assim - Mais top
        cursoSelecionado.ifPresent(c -> System.out.println(c.getNome()));

        //Ou tudo junto tb
        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));
    }


    private static void execRunnable() {
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
