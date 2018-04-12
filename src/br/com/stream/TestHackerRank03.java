package br.com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestHackerRank03 {

    public static void main(String[] args) {
        //int[] numbers = new int[]{4, 2, 1, 3};
        int[] numbers = new int[]{4, -2, -1, 3};
        List<Integer> listAux = new ArrayList<>();
        int counter = numbers.length;
        int arrDefault[] = new int[counter];

        for (int i = 0; i < counter; i++) {
            arrDefault[i] = numbers[i];
        }
        Arrays.sort(arrDefault);

        int firstMin = arrDefault[1] - arrDefault[0];
        listAux.add(arrDefault[0]);
        listAux.add(arrDefault[1]);
        for (int i = 2; i < counter; i++) {
            int secondMin = arrDefault[i] - arrDefault[i - 1];
            if (secondMin < firstMin) {
                listAux.clear();
                listAux.add(arrDefault[i - 1]);
                listAux.add(arrDefault[i]);
                firstMin = secondMin;
            } else if (secondMin == firstMin) {
                listAux.add(arrDefault[i - 1]);
                listAux.add(arrDefault[i]);
            }
        }
        for (int i = 0; i < listAux.size(); i++) {
            System.out.println(listAux.get(i) + " " + listAux.get(i + 1));
            i++;
        }
    }
}