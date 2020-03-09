package br.com.curso.credito.externo;

public class Pessoa {

    private String cpf;
    private String nome;
    private long scoreSerasa;
    private long socreSpc;
    private long qtdeChequesDevolvidos;
    private long valorDivida;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getScoreSerasa() {
        return scoreSerasa;
    }

    public void setScoreSerasa(long scoreSerasa) {
        this.scoreSerasa = scoreSerasa;
    }

    public long getSocreSpc() {
        return socreSpc;
    }

    public void setSocreSpc(long socreSpc) {
        this.socreSpc = socreSpc;
    }

    public long getQtdeChequesDevolvidos() {
        return qtdeChequesDevolvidos;
    }

    public void setQtdeChequesDevolvidos(long qtdeChequesDevolvidos) {
        this.qtdeChequesDevolvidos = qtdeChequesDevolvidos;
    }

    public long getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(long valorDivida) {
        this.valorDivida = valorDivida;
    }
}
