package br.com.modulo02.alunos;

public class Aluno {

    private String login;
    private String cpf;
    private String nome;

    public Aluno(String login, String cpf, String nome) throws ValidationException {
        setLogin(login);
        setCpf(cpf);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void setLogin(String login) throws ValidationException {
        if(validateLogin(login)){
            this.login = login;
        }else{
            throw new ValidationException("Login inválido");
        }
    }

    private boolean validateLogin(String login){
        return login != null && !login.isEmpty() && login.length() < 20;
    }

    public void imprimirDados(){
        System.out.println("Nome: " + nome + ", CPF: " + cpf );
    }


}
