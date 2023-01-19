package ec.edu.espe.conjunta2Cadena.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.conjunta2Cadena.model.Cliente;


public interface ClienteRepository extends MongoRepository<Cliente, String>{
    
    Optional<Cliente> findByCedula(String cedula);
}
