package ec.edu.espe.conjunta2Cadena.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "clientes")
@Data
@Builder
public class Cliente {

    @Id
    public String cedula;
    public String nombres;
    public String apellidos;
    public LocalDateTime nacimiento;
    public String direcciónPrincipal;
    public String teléfono;
    public String email;
    public List<Cuenta> cuentas;
    
    public Cliente() {
    }

    public Cliente(String cedula, String nombres, String apellidos, LocalDateTime nacimiento, String direcciónPrincipal,
            String teléfono, String email, List<Cuenta> cuentas) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.direcciónPrincipal = direcciónPrincipal;
        this.teléfono = teléfono;
        this.email = email;
        this.cuentas = cuentas;
    }
    
}
