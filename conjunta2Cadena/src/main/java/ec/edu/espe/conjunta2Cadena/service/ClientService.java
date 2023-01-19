package ec.edu.espe.conjunta2Cadena.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.conjunta2Cadena.model.Cliente;
import ec.edu.espe.conjunta2Cadena.model.Turno;
import ec.edu.espe.conjunta2Cadena.repository.ClienteRepository;
import ec.edu.espe.conjunta2Cadena.repository.TurnoRepository;

@Service
public class ClientService {
    
    private final ClienteRepository clienteRepo;
    private final TurnoRepository turnoRepo;

    public ClientService(ClienteRepository clienteRepo, TurnoRepository turnoRepo) {
        this.clienteRepo = clienteRepo;
        this.turnoRepo = turnoRepo;
    }



    public Optional<Cliente> findOne(String cedula){
        return clienteRepo.findByCedula(cedula);
    }

    public void generarTurno(Cliente cliente){
        Turno turno = Turno.builder()
            .numero(findTurnoSiguiente())
            .nombreCliente(cliente.getNombres() + " " +cliente.getApellidos())
            .cedulaCliente(cliente.getCedula())
            .build();
        turnoRepo.save(turno);
    }

    public String findTurnoSiguiente(){
        List<Turno> turnos = turnoRepo.findAll();
        List<String> turnosString = new ArrayList<String>();;
        List<Integer> turnosInt = new ArrayList<Integer>();;
        for(Turno turno : turnos){
            turnosString.add(turno.getNumero());
        }
        for(String turno : turnosString){
            turnosInt.add(Integer.parseInt(turno));
        }
        int max = 0;
        for(Integer turno : turnosInt){
            if(turno > max) max = turno;
        }
        return Integer.toString(max);
    }
}
