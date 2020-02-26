package br.com.codenation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

        try{
            LocalDate lt = LocalDate.now();
            desafio.incluirTime(1L, "time1", lt, "azul", "branco");
            desafio.incluirTime(2L, "time1", lt, "azul", "branco");
            desafio.incluirTime(3L, "time1", lt, "azul", "branco");
            System.out.println("---------------");
            desafio.buscarTimes().forEach(System.out::print);
        }catch (Exception ex){
            ex.getMessage();
        }


    }
}
