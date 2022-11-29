package conjunta.espe.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "seg_usuario_espacio")
public class UsuarioEspacio {
    
    @EmbeddedId
    private UsuarioEspacioPk usuarioEspacioPk;

    @Column(name = "rol", length = 3, nullable = false)
    private String rol;

    @Column(name = "estado", length = 32, nullable = false)
    private String estado;

    public UsuarioEspacio(UsuarioEspacioPk pk) {
        this.usuarioEspacioPk = pk;
    }
}
