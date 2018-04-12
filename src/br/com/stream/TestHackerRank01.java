package br.com.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestHackerRank01 {

    public static void main(String[] args) {
        //existeNoArray(1);
        //numerosImparesDeAte(3, 9);
        //arredondamento();
        //ex01();
        //ex02();
        //ex03();
        ex04();
    }

    private static void existeNoArray(int number) {
        int[] listNumbers = new int[3];
        listNumbers[0] = 2;
        listNumbers[1] = 3;
        listNumbers[2] = 1;

        System.out.println(Arrays.stream(listNumbers).filter(n -> n == number).count() > 0 ? "YES" : "NO");
    }

    private static void numerosImparesDeAte(int l, int r) {
        int position = 0;
        int[] listFull = new int[(r - l) + 1];
        for (int i = l; i <= r; i++) {
            listFull[position] = i;
            position++;
        }

        int[] listFiltered = Arrays.stream(listFull).filter(n -> n % 2 != 0).toArray();
        Arrays.stream(listFiltered).forEach(n -> System.out.println(n));
    }

    private static void arredondamento() {
        double d = 12.548795;
        // RoundingMode.HALF_EVEN -> Arredonda pra cima
        BigDecimal bd = new BigDecimal(d).setScale(3, RoundingMode.HALF_EVEN);
        System.out.println(bd.doubleValue());
    }

    private static void ex02() {
        int valor = 161;
        String bin = Integer.toString(valor, 2);

        String[] list = bin.split("");

        Long n1 = Arrays.stream(list).filter(n -> n.equals("1")).count();

        int cont_result = 0;
        int[] result = new int[n1.intValue() + 1];
        result[cont_result] = n1.intValue();

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("1")) {
                cont_result++;
                result[cont_result] = i + 1;
            }
        }
    }

    private static void ex03() {
        int[] arr = new int[]{6, 1, 1, 2, 1, 2, 2};

        int valueMax = 0;
        Map<Integer, Integer> mapDefault = new HashMap<>();
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (mapDefault.containsKey(number)) {
                mapDefault.put(number, mapDefault.get(number) + 1);
            } else {
                start.put(number, i);
                mapDefault.put(number, 1);
            }
            end.put(number, i);
            valueMax = Integer.max(valueMax, mapDefault.get(number));
        }

        int result = arr.length;
        for (int i : mapDefault.keySet()) {
            if (mapDefault.get(i) == valueMax) {
                int otherNumber = end.get(i) - start.get(i) + 1;
                result = Integer.min(result, otherNumber);
            }
        }

        System.out.println(result);
    }

    private static void ex04() {
        int[] arr = new int[]{6, 1, 1, 2, 1, 2, 2};

        Map<Integer, Integer> mapDefault = new HashMap<>();
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        final int[] counter = {0};
        final int[] valueMax = {0};
        Arrays.stream(arr).forEach(number -> {
            if (mapDefault.containsKey(number)) {
                mapDefault.put(number, mapDefault.get(number) + 1);
            } else {
                start.put(number, counter[0]);
                mapDefault.put(number, 1);
            }
            end.put(number, counter[0]);
            valueMax[0] = Integer.max(valueMax[0], mapDefault.get(number));
            counter[0]++;
        });

        final int[] result = {arr.length};
        mapDefault.keySet().stream().forEach(j -> {
            if (mapDefault.get(j) == valueMax[0]) {
                int otherNumber = end.get(j) - start.get(j) + 1;
                result[0] = Integer.min(result[0], otherNumber);
            }
        });

        System.out.println(result[0]);
    }
}