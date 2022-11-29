package conjunta.espe.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class UsuarioEspacioPk {
    
    @Column(name = "cod_espacio", nullable = false)
    private Integer cod_espacio;

    @Column(name = "cod_user", nullable = false)
    private Integer cod_user;
}
