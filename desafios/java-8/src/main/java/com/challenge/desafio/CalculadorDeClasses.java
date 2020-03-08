package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) throws IllegalAccessException {
        return soma(obj, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object obj) throws IllegalAccessException {
        return soma(obj, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object obj) throws IllegalAccessException {
        return somar(obj).subtract(subtrair(obj));
    }

    private BigDecimal soma(Object obj, Class cls ) throws IllegalAccessException {

        BigDecimal soma = BigDecimal.ZERO;

        for(Field fld : obj.getClass().getDeclaredFields()){
            if(fld.isAnnotationPresent(cls) && fld.getType().equals(BigDecimal.class)){
                fld.setAccessible(true);
                soma = soma.add((BigDecimal) fld.get(obj));
            }
        }
        return soma;
    }
}
