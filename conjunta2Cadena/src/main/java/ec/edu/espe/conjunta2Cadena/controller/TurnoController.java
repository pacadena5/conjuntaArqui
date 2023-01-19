package ec.edu.espe.conjunta2Cadena.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.conjunta2Cadena.service.TurnoService;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {
    private TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @RequestMapping(value="/ingreso/{numTurno}/{codEjecutivo}", method= RequestMethod.PUT)
    public ResponseEntity<String> inicioDeAtencion(@PathVariable String numTurno, @PathVariable String codEjecutivo) {
        turnoService.registroInicioAtencion(numTurno, codEjecutivo);
        return ResponseEntity.ok("Ingreso de atencion al sistema");
    }

    @RequestMapping(value="/salida/{numTurno}", method= RequestMethod.PUT)
    public ResponseEntity<String> finDeAtencion(@PathVariable String numTurno) {
        turnoService.registroFinAtencion(numTurno);
        return ResponseEntity.ok("Fin de atencion al sistema");
    }

    @RequestMapping(value="/calificacion/{cedula}/{numTurno}/{calificacion}", method= RequestMethod.PUT)
    public ResponseEntity<String> calificar(@PathVariable String cedula, @PathVariable String numTurno, @PathVariable Integer calificacion) {
        turnoService.calificar(cedula, numTurno, calificacion);
        return ResponseEntity.ok("Fin de atencion al sistema");
    }
}
