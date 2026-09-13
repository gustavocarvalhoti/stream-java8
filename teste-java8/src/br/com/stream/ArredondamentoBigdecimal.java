package br.com.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArredondamentoBigdecimal {

    public static void main(String[] args) {
        arredondamento();
    }

    private static void arredondamento() {
        // RoundingMode.HALF_EVEN -> Arredonda para cima somente se maior - 12.54
        BigDecimal bd1 = new BigDecimal("12.545").setScale(2, RoundingMode.HALF_EVEN);
        System.out.println(bd1.doubleValue());

        // RoundingMode.HALF_EVEN -> Arredonda para baixo - 12.54
        BigDecimal bd2 = new BigDecimal("12.545").setScale(2, RoundingMode.HALF_DOWN);
        System.out.println(bd2.doubleValue());

        // RoundingMode.HALF_EVEN -> Arredonda para cima - 12.55
        BigDecimal bd3 = new BigDecimal("12.545").setScale(2, RoundingMode.HALF_UP);
        System.out.println(bd3.doubleValue());
    }
}