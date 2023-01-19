package ec.edu.espe.conjunta2Cadena.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "ejecutivos")
@Data
public class Ejecutivo {

    @Id
    public String codigo;
    public String nombre;
    public Integer escritorioAsignado;
    
    public Ejecutivo() {
    }
    
    public Ejecutivo(String codigo, String nombre, Integer escritorioAsignado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.escritorioAsignado = escritorioAsignado;
    }

    
}
