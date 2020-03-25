package br.com.curso.relatorios;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class GeradorRelatorio {

    public void gerarRelatorio(List<Object> list, int qtdColunas){
        gerarTitulos(list, qtdColunas);
        gerarLinhas(list, qtdColunas);

    }
    public void gerarLinhas(List<Object> list, int qtdColunas){
        for(Object object : list){
            for(int i = 1; i <= qtdColunas; i++){
                try{
                    System.out.print(getMethodByOrder(object.getClass(), i).invoke(object));
                    if(i< qtdColunas) System.out.print(", ");
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("\n");
        }
    }
    public void gerarTitulos(List<Object> list, int qtdColunas){
        for(int i = 1; i <= qtdColunas; i++){
            System.out.print(getMethodByOrder(list.get(0).getClass(), i).getAnnotation(Coluna.class).titulo());
            if(i< qtdColunas) System.out.print(", ");
        }
        System.out.print("\n");
    }

    private Method getMethodByOrder(Class type, int order){
        Method[] methods = type.getMethods();
        for(Method method: methods){
            if(method.getDeclaredAnnotation(Coluna.class) != null
                && method.getDeclaredAnnotation(Coluna.class).posicao() == order) {
                return method;
            }
        } return null;
    }
}
