package br.com.stream;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {
        ex01();
        compararHoras();
    }

    private static void ex01() {
        // Data atual - 2025-05-14
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        // Calcula a diferença entre as duas datas - 2026-06-05
        LocalDate olimpiadasRio = LocalDate.of(2026, Month.JUNE, 15);
        int difDatas = olimpiadasRio.getYear() - hoje.getYear();
        System.out.println("Falta " + difDatas + " ano(s) para a Olimpiada.");

        // Calcula a diferença de duas datas
        Period periodo = Period.between(hoje, olimpiadasRio);
        System.out.println("Periodo: " + periodo);
        System.out.println(
                "Falta "
                        + periodo.getYears() + " ano(s) "
                        + periodo.getMonths() + " meses(s) e "
                        + periodo.getDays() + " dia(s) para a Olimpiada."
        );

        // Alterando a data 2025-05-14 Minus: remove, Plus: add
        System.out.println(hoje + " -1 ano > " + hoje.minusYears(1));
        System.out.println(hoje + " -1 mês > " + hoje.minusMonths(1));
        System.out.println(hoje + " -1 dia > " + hoje.minusDays(1));
        System.out.println(hoje + " +1 ano > " + hoje.plusYears(1));
        System.out.println(hoje + " +1 mês > " + hoje.plusMonths(1));
        System.out.println(hoje + " +1 dia > " + hoje.plusDays(1));

        // Imprimir no formato String - localDateToString - 2026-06-05
        DateTimeFormatter localDateToString = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(olimpiadasRio.format(localDateToString));

        // Imprimir no formato String - localDateTimeToString
        // Data como minutos - 14/05/2025 23:07:28 (HH CASE para pegar no formato 24h)
        DateTimeFormatter localDateTimeToString = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(localDateTimeToString));

        // Ano-mes - 2015-02
        YearMonth anoEMes1 = YearMonth.of(2015, Month.JANUARY);
        YearMonth anoEMes2 = YearMonth.of(2015, Month.FEBRUARY);
        if (anoEMes1.isBefore(anoEMes2)) {
            System.out.println(anoEMes2 + " vem depois de " + anoEMes1);
        }

        // Hora - 12:30
        LocalTime hora1 = LocalTime.of(12, 30);
        LocalTime hora2 = LocalTime.of(14, 30);
        if (hora2.isAfter(hora1)) {
            System.out.println(hora1 + " vem antes de " + hora2);
        }
    }

    private static void compararHoras() {
        // Retorne indicando se os intervalos se sobrepõem.
        // Test1: [10:00, 11:00) e [10:30, 11:30)  → sobrepõem
        // Test2: [10:00, 11:00) e [11:30, 12:30)  → não sobrepõem

        LocalTime hora1 = LocalTime.of(10, 00);
        LocalTime hora2 = LocalTime.of(11, 00);
        LocalTime hora3 = LocalTime.of(10, 30);
        LocalTime hora4 = LocalTime.of(11, 30);

        // Before = Antes
        // After  = Depois
        if (hora3.isBefore(hora2) || hora4.isBefore(hora2)) {
            System.out.println("Sobrepõem");
        } else {
            System.out.println("Não sobrepõem");
        }
    }

}