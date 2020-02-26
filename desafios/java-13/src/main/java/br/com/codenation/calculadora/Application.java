package br.com.codenation.calculadora;

public class Application {

    public static void main (String[] args){
        CalculadoraSalario calculadoraSalario = new CalculadoraSalario();

        System.out.println(calculadoraSalario.calcularSalarioLiquido(10000.00));
    }
}
