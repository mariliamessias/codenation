package br.com.curso.credito;

import java.util.ArrayList;
import java.util.List;

public class RegrasCreditoRepository {

    public List<RegraCredito> findAllRegras(){
        List<RegraCredito> regras = new ArrayList<>();

        RegraCredito regra1 = new RegraCredito();
        regra1.setNome("ScoreSerasa");
        regra1.setReferencia("scoreSerasa");
        regra1.setValorReferencia(500);
        regra1.setRegra(RegraCredito.Regravalor.MIN);

        RegraCredito regra2 =  new RegraCredito();
        regra2.setNome("Valor Dívida");
        regra2.setReferencia("valorDivida");
        regra2.setValorReferencia(1000);
        regra2.setRegra(RegraCredito.Regravalor.MAX);

        regras.add(regra1);
        regras.add(regra2);

        return regras;
    }

}
