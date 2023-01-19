package ec.edu.espe.conjunta2Cadena.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.conjunta2Cadena.model.Cliente;
import ec.edu.espe.conjunta2Cadena.model.Ejecutivo;
import ec.edu.espe.conjunta2Cadena.model.Turno;
import ec.edu.espe.conjunta2Cadena.repository.ClienteRepository;
import ec.edu.espe.conjunta2Cadena.repository.EjecutivoRepository;
import ec.edu.espe.conjunta2Cadena.repository.TurnoRepository;

@Service
public class TurnoService {
    private final TurnoRepository turnoRepo;
    private final EjecutivoRepository ejecutivoRepo;
    private final ClienteRepository clienteRepo;

    public TurnoService(TurnoRepository turnoRepo, EjecutivoRepository ejecutivoRepo, ClienteRepository clienteRepo) {
        this.turnoRepo = turnoRepo;
        this.ejecutivoRepo = ejecutivoRepo;
        this.clienteRepo = clienteRepo;
    }

    public void registroInicioAtencion(String numTurno, String codEjecutivo){
        Optional<Turno> turnoOpt =  turnoRepo.findById(numTurno);
        Optional<Ejecutivo> ejecutivoOpt = ejecutivoRepo.findById(codEjecutivo);

        if(turnoOpt.isPresent() && ejecutivoOpt.isPresent()){
            Turno turno = turnoOpt.get();
            turno.setNombreEjecutivo(ejecutivoOpt.get().getNombre());
            turno.setFechaInicioAtencion(LocalDateTime.now());
            try {
                turnoRepo.save(turno);
            } catch (Exception e) {
                throw new RuntimeException("Excepcion registrando la fecha de inicio de atencion> "+    e);
            }
            turnoRepo.save(turno);
        }else throw new RuntimeException("El ejecutivo o el turno no existen");
    }
    
    public void registroFinAtencion(String numTurno){
        Optional<Turno> turnoOpt =  turnoRepo.findById(numTurno);
        
        if(turnoOpt.isPresent() ){
            Turno turno = turnoOpt.get();
            turno.setFechaFinAtencion(LocalDateTime.now());
            try {
                turnoRepo.save(turno);
            } catch (Exception e) {
                throw new RuntimeException("Excepcion registrando la fecha de inicio de atencion> "+ e);
            }
            turnoRepo.save(turno);
        }else {
            throw new RuntimeException("El ejecutivo o el turno no existen");
        }
    }

    public void calificar(String cedula, String numTurno, Integer calificacion){
        if(!validar(cedula, numTurno, calificacion)){
            throw new RuntimeException("Datos invalidos en metodo calificar");
        }
        Turno turno =  turnoRepo.findById(numTurno).get();
        try {
            turno.setCalificacion(calificacion);
        } catch (Exception e) {
            throw new RuntimeException("Excepcion registrando la calificacion> "+ e);
        }

    }

    public boolean validar(String cedula, String numTurno, Integer calificacion){
        boolean band = true;
        Optional<Cliente> clienteOpt =  clienteRepo.findById(cedula);
        Optional<Turno> turnoOpt =  turnoRepo.findById(numTurno);
        if(turnoOpt.isPresent() && clienteOpt.isPresent()) band = false;
        if(calificacion < 0 || calificacion > 5) band = false;
        return band;
    }
}
