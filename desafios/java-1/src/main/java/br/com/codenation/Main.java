package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DesafioMeuTimeApplication app = new DesafioMeuTimeApplication();

        app.incluirTime(1L, "Flamengo", LocalDate.now(), "vermelho", "branco");
        app.incluirJogador(3L, 1L, "Bruno", LocalDate.now(), 99, new BigDecimal(1500000));
        app.incluirJogador(2L, 1L, "Gabigol", LocalDate.now(), 89, new BigDecimal(1600000));
        app.definirCapitao(3L);

        app.incluirTime(2L, "Palmeiras", LocalDate.now(), "verde", "amarelo");
        app.incluirJogador(1L, 2L, "Felipe", LocalDate.now(), 78, new BigDecimal(800000));
        app.definirCapitao(1L);

        System.out.println("Capitão do " + app.buscarNomeTime(1L) + " = " + app.buscarCapitaoDoTime(1L));
        System.out.println("Jogadores do " + app.buscarNomeTime(1L) + " = " + app.buscarJogadoresDoTime(1L));
        System.out.println("Melhor jogador do " + app.buscarNomeTime(1L) + " = " + app.buscarMelhorJogadorDoTime(1L));

        System.out.println("Lista de melhores jogadores = " + app.buscarTopJogadores(5));
    }
}
