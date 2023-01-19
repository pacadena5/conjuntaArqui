package ec.edu.espe.conjunta2Cadena.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.conjunta2Cadena.model.Turno;

public interface TurnoRepository extends MongoRepository<Turno, String>{
    Optional<Turno> findByNumero(String numero);
}
