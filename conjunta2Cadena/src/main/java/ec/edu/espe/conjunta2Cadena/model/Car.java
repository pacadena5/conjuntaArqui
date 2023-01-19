package ec.edu.espe.conjunta2Cadena.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    public String model;
    public Integer placa;

    public Car() {
    }

    public Car(String model, Integer placa) {
        this.model = model;
        this.placa = placa;
    }

}
