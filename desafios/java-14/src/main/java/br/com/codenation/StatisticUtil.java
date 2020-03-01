package br.com.codenation;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) IntStream.of(elements).average().orElse(0);
	}

	public static int mode(int[] elements) {

		int mode = 0;
		int frequencyValue = 0;

		for(int element : elements){
			int frequencyValueTemp = findFrequency(elements, element);
			if(frequencyValueTemp > frequencyValue){
				mode = element;
				frequencyValue = frequencyValueTemp;
			}
		}

		return mode;
	}

	private static int findFrequency(int[] elements, int element){
		int qtdeElements = 0;
		for(int i = 0; i < elements.length; i++){
			if(elements[i] == element) qtdeElements++;
		}
		return qtdeElements;
	}

	public static int median(int[] elements) {

		Arrays.sort(elements);

		if((elements.length) % 2 == 0){
			return (elements[(elements.length / 2) - 1] + elements[(elements.length / 2)]) / 2;
		} else return elements[elements.length/2];

	}
}