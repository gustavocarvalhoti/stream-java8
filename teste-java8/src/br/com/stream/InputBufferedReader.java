package br.com.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputBufferedReader {

    public static void main(String[] args) throws IOException {
        exercise01();
    }

    private static void exercise01() {
        Scanner input = new Scanner(System.in);
        Scanner inputText = new Scanner(System.in);

        int i = input.nextInt();
        double d = input.nextDouble();
        String s = inputText.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

    private static void exercise02() {
        System.out.println("================================");

        Scanner input = new Scanner(System.in);

        var value = input.nextLine();
        var values = value.split(" ");
        fillNumbers(values);

        value = input.nextLine();
        values = value.split(" ");
        fillNumbers(values);

        value = input.nextLine();
        values = value.split(" ");
        fillNumbers(values);

        System.out.println("================================");
    }

    private static void fillNumbers(String[] values) {
        var start = values[0];
        var addSpace = 15 - start.length();
        while (addSpace > 0) {
            start += " ";
            addSpace--;
        }

        var end = values[1];
        var addZero = 3 - end.length();
        while (addZero > 0) {
            end = "0" + end;
            addZero--;
        }
        System.out.println(start + end);
    }

    private static void exercise03() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine().trim());
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }

        input.close();
    }

    private static void exercise04() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        double d = Double.parseDouble(input.readLine());
        String s = input.readLine();
        input.close();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + n);
    }

    private static void exercise05() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int nQuerys = Integer.parseInt(input.readLine());
        while (nQuerys > 0) {
            String line = input.readLine();
            var values = line.split(" ");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            var n = Integer.parseInt(values[2]);

            fillCalc(n, b, a);
            System.out.println();
            nQuerys--;
        }
    }

    private static void fillCalc(int n, int b, int a) {
        var result = 0;
        int factMult = 0;
        while (n > 0) {
            // Add factMult x B
            if (factMult > 0) {
                result += (factMult * b);
                factMult = factMult * 2;
            } else {
                result = a + 1 * b;
                factMult = 2;
            }

            System.out.print(result + " ");
            n--;
        }
    }

    private static void exercise06() {
        Scanner input = new Scanner(System.in);

        int nTests = input.nextInt();
        input.nextLine();
        for (int i = 0; i < nTests; i++) {
            String numString = input.nextLine();
            System.out.println(canPrintNumber(numString));
        }
    }

    static String canPrintNumber(String numString) {
        String result = "";
        try {
            long num = Long.parseLong(numString);
            result = numString + " can be fitted in:\n";
            if ((num <= Byte.MAX_VALUE) && (num >= Byte.MIN_VALUE)) {
                result = result.concat("* byte\n* short\n* int\n* long");
            } else if ((num <= Short.MAX_VALUE) && (num >= Short.MIN_VALUE)) {
                result = result.concat("* short\n* int\n* long");
            } else if ((num <= Integer.MAX_VALUE) && (num >= Integer.MIN_VALUE)) {
                result = result.concat("* int\n* long");
            } else {
                result = result.concat("* long");
            }
        } catch (NumberFormatException e) {
            result = numString + " can't be fitted anywhere.";
        }
        return result;
    }

}