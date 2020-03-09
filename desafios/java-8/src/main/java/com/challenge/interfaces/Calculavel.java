package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {
    BigDecimal somar(Object obj) throws IllegalAccessException;
    BigDecimal subtrair(Object obj) throws IllegalAccessException;
    BigDecimal totalizar(Object obj) throws IllegalAccessException;
}
