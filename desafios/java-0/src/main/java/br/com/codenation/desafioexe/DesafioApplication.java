package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

		List<Integer> listaNumeros = new ArrayList<>();

		int  indice = 0;
		do{
			if(indice <= 1) {
				listaNumeros.add(indice);
			} else {
				listaNumeros.add(listaNumeros.get(indice-1) + listaNumeros.get(indice-2));

			}
			indice++;

		}while(listaNumeros.get(indice-1) < 350);

		return listaNumeros;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

	public static void main(String[] args) {
		for (Integer numero : fibonacci()) {
			System.out.printf("%d ", numero);
		}
	}

}

