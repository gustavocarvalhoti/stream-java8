package br.com.alura;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ApiDatas {

  public static void main(String[] args) {
    ex01();
  }

  private static void ex01() {
    System.out.println("***********************************************************************");
    LocalDate hoje = LocalDate.now();
    System.out.println(hoje);

    System.out.println("***********************************************************************");
    // Calcula a diferença entre as duas datas
    LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
    int difDatas = hoje.getYear() - olimpiadasRio.getYear();
    System.out.println(difDatas + " anos");

    System.out.println("***********************************************************************");
    //Resposta - P-2Y-17D - 2 anos e 17 dias
    Period periodo = Period.between(olimpiadasRio, hoje);
    System.out.println(periodo);
    System.out.println("Anos: " + periodo.getYears());
    System.out.println("Meses: " + periodo.getMonths());
    System.out.println("Dias: " + periodo.getDays());

    System.out.println("***********************************************************************");
    System.out.println(hoje.minusYears(1));
    System.out.println(hoje.minusMonths(1));
    System.out.println(hoje.minusDays(1));
    System.out.println(hoje.plusYears(1));
    System.out.println(hoje.plusMonths(1));
    System.out.println(hoje.plusDays(1));

    // Incremento
    // Da mesma forma que as novas API's, como o Stream, os métodos da API de datas sempre vão retornar uma nova instancia da sua data
    LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
    System.out.println(proximasOlimpiadas);

    System.out.println("***********************************************************************");
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String valorFormatado = proximasOlimpiadas.format(formatador);
    System.out.println(valorFormatado);

    System.out.println("***********************************************************************");
    System.out.println("Medidas de tempo");
    DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
    LocalDateTime agora = LocalDateTime.now();
    System.out.println(agora.format(formatadorComHoras));

    System.out.println("***********************************************************************");
    System.out.println("Modelos mais específicos");
    // Ano-mes
    YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);
    System.out.println(anoEMes);
    // Hora
    LocalTime intervalo = LocalTime.of(12, 30);
    System.out.println(intervalo);
  }
}