package br.com;

import br.com.tarefas.ArrayTarefas;
import br.com.tarefas.ListaTarefas;
import br.com.tarefas.Tarefa;

public class Principal {

    public static void main(String[] args){

        ListaTarefas tarefas = new ListaTarefas();
        tarefas.adicionar("Limpar a casa antes de sair para trabalhar");
        tarefas.adicionar("Trabalhar");
        tarefas.adicionar("Lavar a roupa");

        System.out.println("Minhas tarefas");
        System.out.println("----------------------");
        Tarefa tarefa = tarefas.buscar("Trabalhar");
        tarefa.exibirTarefa();

//        System.out.println("A tarefa tem " + tarefa1.obterTamanhoTarefa() + " caracteres");
    }
}
