package br.com.curso.credito;

import br.com.curso.credito.externo.Pessoa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnalisadorCredito {
    private RegrasCreditoRepository repository;

    public AnalisadorCredito(){
        this.repository = new RegrasCreditoRepository();
    }

    public boolean analisarCredito(Pessoa pessoa){
        Method[] methods = Pessoa.class.getDeclaredMethods();
        boolean result = true;
       for(RegraCredito regra : repository.findAllRegras()){
           for(Method method: methods){
               if(method.getName().toUpperCase().contains("GET" + regra.getReferencia().toUpperCase())){
                   try{
                       long valor = (long) method.invoke(pessoa);
                       result = validarRegra(valor, regra);
                       if(!result) return false;

                   } catch (IllegalAccessException | InvocationTargetException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
       return result;
    }

    private boolean validarRegra(long valor, RegraCredito regra){
        if(regra.getRegra().equals(RegraCredito.Regravalor.MAX)){
            return valor <= regra.getValorReferencia();
        }else{
            return valor >= regra.getValorReferencia();
        }
    }

}
