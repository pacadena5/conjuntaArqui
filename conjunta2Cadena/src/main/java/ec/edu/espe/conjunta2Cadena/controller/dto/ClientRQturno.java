package ec.edu.espe.conjunta2Cadena.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRQturno implements Serializable{
    
    public String cedula;
    public String nombres;
    public String apellidos;
}
