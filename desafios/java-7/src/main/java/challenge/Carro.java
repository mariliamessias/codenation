package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            validaMotorista(motorista);
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            validaPlaca(placa);
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            validaCor(cor);
            this.cor = cor;
            return this;
        }

        public Carro build() {
            validaCor(cor);
            validaPlaca(placa);
            validaMotorista(motorista);

            return new Carro(motorista, placa, cor);
        }

        private void validaPlaca(String placa){
            if(placa.isEmpty() || placa == null) throw new NullPointerException("Placa inválida!");
        }

        private void validaCor(Cor cor){
            if(cor.toString().isEmpty() || cor == null) throw new NullPointerException("Cor inválida!");
        }

        private void validaMotorista(Motorista motorista){
            if(motorista == null) throw new EstacionamentoException("Motorista não informado");

        }
    }
}
