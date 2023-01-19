package ec.edu.espe.conjunta2Cadena.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "customers")
@Data
public class Customer {
    
    @Id
    public String id;

    public String firstName;
    public String lastName;
    public List<Car> cars;

    public Customer() {
    }

    public Customer(String id, String firstName, String lastName, List<Car> cars) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cars = cars;
    }

}
