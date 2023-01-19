package ec.edu.espe.conjunta2Cadena.controller.mapper;

import ec.edu.espe.conjunta2Cadena.controller.dto.ClientRQturno;
import ec.edu.espe.conjunta2Cadena.controller.dto.ClienteRS;
import ec.edu.espe.conjunta2Cadena.model.Cliente;

public class ClienteMapper {
    
    public static ClienteRS toClientRS(Cliente cliente){
        return ClienteRS.builder()
            .cedula(cliente.getCedula())
            .nombres(cliente.getNombres())
            .apellidos(cliente.getApellidos())
            .build();
    }

    public static Cliente toClient(ClientRQturno clienteRQ){
        return Cliente.builder()
            .cedula(clienteRQ.getCedula())
            .nombres(clienteRQ.getNombres())
            .apellidos(clienteRQ.getApellidos())
            .build();
    }
}
