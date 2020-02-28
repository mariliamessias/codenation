package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> carros = new ArrayList<Carro>();

    public void estacionar(Carro carro) {
        if(carro.getMotorista().getIdade() < 18){
            throw new EstacionamentoException("Motorista menor de idade!");
        }
        if(carro.getMotorista().getPontos() > 20){
            throw new EstacionamentoException("Motorista com muitos pontos!");
        }

        if(carrosEstacionados() == 10){
            final Carro carroEstacionado = carros
                    .stream()
                    .filter(carro1 -> carro1.getMotorista().getIdade() < 55)
                    .findFirst()
                    .orElseThrow(() -> new EstacionamentoException("Carro não incluído"));

            carros.remove(carroEstacionado);
        }

        carros.add(carro);
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }
}
