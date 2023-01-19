package ec.edu.espe.conjunta2Cadena.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.conjunta2Cadena.model.Ejecutivo;

public interface EjecutivoRepository extends MongoRepository<Ejecutivo, String>{
    
}
