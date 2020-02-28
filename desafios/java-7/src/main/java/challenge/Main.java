package challenge;

public class Main {
    public static void main (String[] args){

        final Motorista.MotoristaBuilder ada =  Motorista.builder()
                .withIdade(-1);

        System.out.println(ada);
    }
}
