package conjunta.espe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gdc_espacio")
public class Espacio {
    
    @Id
	@Column(name = "cod_espacio", nullable = false)
    private Integer cod_espacio;

    @Column(name = "nombre", length = 128, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String fecha_creacion;

    @Column(name = "visibilidad", length = 500, nullable = false)
    private String visibilidad;

    public Espacio(Integer pk) {
        this.cod_espacio = pk;
    }
}
