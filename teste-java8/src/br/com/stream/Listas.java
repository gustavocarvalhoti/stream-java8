package br.com.stream;

import br.com.stream.model.Pessoa;

import java.util.*;

public class Listas {

    public static void main(String[] args) {
        ex01();
    }

    private static void ex01() {
        Pessoa p1 = new Pessoa("P1: Gustavo", 36);
        Pessoa p2 = new Pessoa("P2: Duda", 10);
        Pessoa p3 = new Pessoa("P3: Davi", 7);
        Pessoa p4 = new Pessoa("P4: Michelle", 34);

        // Array simples
        System.out.println("arraySimples ********************");
        Pessoa[] arraySimples = {p4, p2, p3, p1};
        System.out.println(Arrays.toString(arraySimples));

        // Usa um array basico para salvar os itens
        // Remove da ultima posição mais rapido que o LinkedList
        System.out.println("pessoaList ********************");
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.addFirst(p1);
        pessoaList.add(1, p2);
        // Ele joga o de cima para a frente
        pessoaList.add(1, p3);
        pessoaList.addLast(p4);
        System.out.println(pessoaList);

        // Indicado quando tem muitas operações de insert e remove
        // Busca um e depois outro até chegar na posição desejada
        // Flexibilidade para inserção e remoção de elementos, especialmente no meio da lista
        // Usa um conjunto de objetos chamados de “nós” (node, em inglês) que armazenam três coisas:
        // O valor do elemento em si, o endereço de memória do item anterior e o endereço de memória do próximo item da lista.
        // Por isso, esse tipo de estrutura é chamada também de lista duplamente encadeada, ou doubly linked list.
        // Mais custoso fazer um get, ele percorre 1 a 1
        // Mais rapido para adicionar ou remover na lista (Ele só só mexe nas referências da head e dos elementos
        // anterior e posterior ao novo item inserido.)
        // Para inserir na ultima posição tem a mesma valocidade que o ArrayList
        System.out.println("pessoaLinkedList ********************");
        List<Pessoa> pessoaLinkedList = new LinkedList<>();
        pessoaLinkedList.add(0, p1);
        pessoaLinkedList.add(1, p2);
        // Ele joga o de cima para a frente
        pessoaLinkedList.add(1, p3);
        System.out.println(pessoaLinkedList);

        // Não repete a key
        System.out.println("HashMapPessoa ********************");
        Map hashMapPessoa = new HashMap();
        hashMapPessoa.put(1, p1);
        // Esse grava em cima do primeiro
        hashMapPessoa.put(1, p2);
        System.out.println(hashMapPessoa);

        // Não garante a ordenação
        System.out.println("HashMapIntPessoa ********************");
        Map<Integer, Pessoa> hashMapIntPessoa = new HashMap<Integer, Pessoa>();
        hashMapIntPessoa.put(4, p4);
        hashMapIntPessoa.put(3, p3);
        hashMapIntPessoa.put(2, p2);
        hashMapIntPessoa.put(1, p1);
        System.out.println(hashMapIntPessoa);

        // Garante a ordenação
        System.out.println("sortedMapIntPessoa ********************");
        SortedMap<Integer, Pessoa> sortedMapIntPessoa = new TreeMap<Integer, Pessoa>();
        sortedMapIntPessoa.put(4, p4);
        sortedMapIntPessoa.put(3, p3);
        sortedMapIntPessoa.put(2, p2);
        sortedMapIntPessoa.put(1, p1);
        System.out.println(sortedMapIntPessoa);
    }

    private static void ex02() {
        List<Pessoa> listaPessoas = Arrays.asList(
                new Pessoa("Joao", 32),
                new Pessoa("Antonio", 20),
                new Pessoa("Maria", 18),
                new Pessoa("Gustavo", 18),
                new Pessoa("Angela", 30)
        );
        // Imprime o nome das pessoas
        listaPessoas.forEach(p -> System.out.println(p.getNome()));

        // Imprime os valores da lista
        List<Integer> listaInteger = Arrays.asList(1, 2, 3);
        listaInteger.forEach(System.out::println);
    }

}
