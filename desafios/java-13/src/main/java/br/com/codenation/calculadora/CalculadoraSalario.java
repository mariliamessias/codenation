package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		if(salarioBase >  1039.00){
			double res = salarioBase - calcularInss(salarioBase);
			return Math.round(res - calcularIrrf(res));
		} else return  Math.round(0.0);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		return salarioBase * aliquotaInss(salarioBase);
	}

	private double calcularIrrf(double salarioBase){
		return salarioBase * aliquotaIrrf(salarioBase);
	}

	private double aliquotaIrrf(double salarioBase ){

		if(salarioBase > 3000.00 && salarioBase <= 6000.00){
			return 0.075;
		}else if (salarioBase > 6001.00){
			return 0.15;
		}else return 0.00;
	}

	private double aliquotaInss(double salarioBase){
		if(salarioBase <= 1500.00){
			return 0.08;
		}else if (salarioBase <= 4000.00){
			return 0.09;
		}else {
			return 0.11;
		}
	}

}
