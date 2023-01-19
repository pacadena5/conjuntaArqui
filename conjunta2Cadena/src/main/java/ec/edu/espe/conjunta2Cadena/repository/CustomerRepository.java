package ec.edu.espe.conjunta2Cadena.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.conjunta2Cadena.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
    
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByCarsModel(String model);
}
