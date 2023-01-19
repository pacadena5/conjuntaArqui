package ec.edu.espe.conjunta2Cadena.controller;

import java.util.Optional;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.conjunta2Cadena.controller.dto.ClientRQturno;
import ec.edu.espe.conjunta2Cadena.controller.dto.ClienteRS;
import ec.edu.espe.conjunta2Cadena.controller.mapper.ClienteMapper;
import ec.edu.espe.conjunta2Cadena.model.Cliente;
import ec.edu.espe.conjunta2Cadena.model.Turno;
import ec.edu.espe.conjunta2Cadena.service.ClientService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClientService clienteService;

    public ClienteController(ClientService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(value="/{cedula}", method= RequestMethod.GET)
    public ResponseEntity<ClienteRS> obtenerCliente(@PathVariable String cedula) {
        Optional<Cliente> clienteOpt = clienteService.findOne(cedula);
        if(clienteOpt.isPresent()){
            ClienteRS clienteRS = ClienteMapper.toClientRS(clienteOpt.get());
            return ResponseEntity.ok(clienteRS);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public ResponseEntity<String> sacarTurno(@RequestBody ClientRQturno clienteRQ) {
        Cliente cliente = ClienteMapper.toClient(clienteRQ);
        clienteService.generarTurno(cliente);
        return ResponseEntity.ok("Turno generado");
    }

}
