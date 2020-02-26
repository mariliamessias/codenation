package br.com.codenation.jogadores;

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
        this.dataNascimento = dataNascimento;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    private boolean validaId(Long id){
        return !Objects.isNull(id) && !String.valueOf(id).isEmpty();
    }

    private boolean validaNome(String nome){
        return !Objects.isNull(nome) && !nome.isEmpty();
    }

    private boolean validaData(LocalDate data){
        return !Objects.isNull(data) && !String.valueOf(data).isEmpty() && data.isBefore(LocalDate.now());
    }
    private boolean validaHabilidade(Integer valor){
        return !Objects.isNull(valor) && (valor >=0 && valor<=100);
    }

    private boolean validaSalario(BigDecimal s) {
        return s!=null && s.doubleValue()>0.0;
    }

}
