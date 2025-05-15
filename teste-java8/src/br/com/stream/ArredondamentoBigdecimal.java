package br.com.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArredondamentoBigdecimal {

    public static void main(String[] args) {
        arredondamento();
    }

    private static void arredondamento() {
        double d = 12.548795;
        // RoundingMode.HALF_EVEN -> Arredonda pra cima
        BigDecimal bd = new BigDecimal(d).setScale(3, RoundingMode.HALF_EVEN);
        System.out.println(bd.doubleValue());
    }
}