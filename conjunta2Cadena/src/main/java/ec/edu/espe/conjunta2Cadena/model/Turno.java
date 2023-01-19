package ec.edu.espe.conjunta2Cadena.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "turnos")
@Data
@Builder
public class Turno {
    
    @Id
    public String numero;
    public String cedulaCliente;
    public String nombreCliente;
    public String codigoEjecutivo;
    public String nombreEjecutivo;
    public LocalDateTime fechaFeneracion;
    public LocalDateTime fechaInicioAtencion;
    public LocalDateTime fechaFinAtencion;
    public Integer calificacion;
    
    public Turno() {
    }
    
    public Turno(String numero, String cedulaCliente, String nombreCliente, String codigoEjecutivo,
            String nombreEjecutivo, LocalDateTime fechaFeneracion, LocalDateTime fechaInicioAtencion,
            LocalDateTime fechaFinAtencion, Integer calificacion) {
        this.numero = numero;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.codigoEjecutivo = codigoEjecutivo;
        this.nombreEjecutivo = nombreEjecutivo;
        this.fechaFeneracion = fechaFeneracion;
        this.fechaInicioAtencion = fechaInicioAtencion;
        this.fechaFinAtencion = fechaFinAtencion;
        this.calificacion = calificacion;
    }
    
}
