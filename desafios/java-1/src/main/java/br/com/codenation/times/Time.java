package br.com.codenation.times;

import br.com.codenation.jogadores.Jogador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Time {

    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Long capitaoId;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        setId(id);
        setNome(nome);
        setDataCriacao(dataCriacao);
        setCorUniformePrincipal(corUniformePrincipal);
        setCorUniformeSecundario(corUniformeSecundario);
    }

    public Long getId() {
        return id;
    }

    public Long getCapitaoId() {
        return capitaoId;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCapitaoId(Long capitaoId) {
        this.capitaoId = capitaoId;
    }

    public void setId(Long id) {
        if(this.validaId(id)) this.id = id;
        else throw new NullPointerException("Id inválido!");
    }

    public void setNome(String nome) {
        if(this.validaNome(nome)) this.nome = nome;
        else throw new NullPointerException("Nome inválido!");
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        if(this.validaData(dataCriacao))  this.dataCriacao = dataCriacao;
        else throw new NullPointerException("Data inválida!");
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        if(this.validaCorUniforme(corUniformePrincipal))  this.corUniformePrincipal = corUniformePrincipal;
        else throw new NullPointerException("Cor de uniforme inválida!");
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        if(this.validaCorUniforme(corUniformeSecundario)) this.corUniformeSecundario = corUniformeSecundario;
        else throw new NullPointerException("Cor de uniforme inválida!");
    }

    private boolean validaId(Long id){
        return !Objects.isNull(id) && !String.valueOf(id).isEmpty();
    }

    private boolean validaNome(String nome){
        return !Objects.isNull(nome) && !nome.isEmpty();
    }

    private boolean validaData(LocalDate data){
        return !Objects.isNull(data) && !String.valueOf(data).isEmpty() && data.isEqual(LocalDate.now());
    }
    private boolean validaCorUniforme(String cor){
        return !Objects.isNull(cor) && !cor.isEmpty();
    }

}
