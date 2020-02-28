package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Jogador {
    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

        setId(id);
        setNome(nome);
        setIdTime(idTime);
        setDataNascimento(dataNascimento);
        setNivelHabilidade(nivelHabilidade);
        setSalario(salario);
    }

    public Long getId() {
        return id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setId(Long id) {
        if(this.validaId(id)) this.id = id;
        else throw new NullPointerException("Id inválido!");
    }

    public void setIdTime(Long idTime) {
        if(this.validaId(idTime)) this.idTime = idTime;
        else throw new NullPointerException("Id do Time inválido!");
    }

    public void setNome(String nome) {
        if(this.validaNome(nome)) this.nome = nome;
        else throw new NullPointerException("Nome inválido!");
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if(validaData(dataNascimento)) this.dataNascimento = dataNascimento;
        else throw new NullPointerException("Data inválida!");
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {

        if(validaHabilidade(nivelHabilidade)) this.nivelHabilidade = nivelHabilidade;
        else throw new NullPointerException("Nível de habilidade inválido!");
    }

    public void setSalario(BigDecimal salario) {
        if(validaSalario(salario)) this.salario = salario;
        else throw new NullPointerException("Salário inválido!");
    }

    private boolean validaId(Long id){
        return id != null  && !String.valueOf(id).isEmpty();
    }

    private boolean validaNome(String nome){
        return nome != null && !nome.isEmpty();
    }

    private boolean validaData(LocalDate data){
        return data != null  && !String.valueOf(data).isEmpty();
    }
    private boolean validaHabilidade(Integer valor){
        return valor != null  && (valor >=0 && valor<=100);
    }

    private boolean validaSalario(BigDecimal salario) {
        return salario != null && salario.doubleValue() > 0.0;
    }

}
