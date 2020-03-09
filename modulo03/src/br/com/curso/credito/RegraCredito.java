package br.com.curso.credito;

public class RegraCredito {
    private String nome;
    private String referencia;
    private long valorReferencia;
    private Regravalor regra;

    public enum Regravalor{
        MAX, MIN;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(long valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public Regravalor getRegra() {
        return regra;
    }

    public void setRegra(Regravalor regra) {
        this.regra = regra;
    }
}
