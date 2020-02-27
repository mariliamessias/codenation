package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args){
        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

        try{
            LocalDate lt = LocalDate.now();
            LocalDate idade = LocalDate.of(2014, Month.JANUARY, 1);
            LocalDate idade2 = LocalDate.of(1992, Month.FEBRUARY, 10);

            desafio.incluirTime(1L, "time1", lt, "azul", "branco");
            desafio.incluirTime(2L, "time1", lt, "rosa", "branco");
            desafio.incluirTime(3L, "time1", lt, "azul", "branco");

            desafio.incluirJogador(1L, 3L, "jogador1", idade, 100, BigDecimal.valueOf(1000.0));
            desafio.incluirJogador(4L, 1L, "jogador2", idade, 88, BigDecimal.valueOf(100.0));
            desafio.incluirJogador(3L, 1L, "jogador3", idade2, 100, BigDecimal.valueOf(100.0));


            desafio.definirCapitao(1L);
            desafio.definirCapitao(4L);

            System.out.println("---------------");
            desafio.buscarTimes().forEach(System.out::println);
            System.out.println("---------------");
            System.out.println(desafio.buscarJogadorMaisVelho(1L));
            System.out.println("---------------");
            System.out.println(desafio.buscarCapitaoDoTime(1L));
            System.out.println("---------------");
            System.out.println(desafio.buscarNomeJogador(4L));
            System.out.println("---------------");
            System.out.println(desafio.buscarNomeTime(3L));
            System.out.println("---------------");
            System.out.println(desafio.buscarJogadoresDoTime(1L));
            System.out.println("---------------");
            System.out.println(desafio.buscarMelhorJogadorDoTime(1L));
            System.out.println("---------------");
            System.out.println(desafio.buscarJogadorMaisVelho(1L));
            System.out.println("---------------");
            System.out.println(desafio.buscarTimes());
            System.out.println("---------------");
            System.out.println(desafio.buscarJogadorMaiorSalario(1L));
            System.out.println("---------------");
            System.out.println(desafio.buscarSalarioDoJogador(1L));
            System.out.println("---------------");
            System.out.println(desafio.buscarTopJogadores(2));
            System.out.println("---------------");
            System.out.println(desafio.buscarCorCamisaTimeDeFora(2L, 1L));
        }catch (Exception ex){
            ex.getMessage();
        }


    }
}
