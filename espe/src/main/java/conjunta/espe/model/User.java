package conjunta.espe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "seg_user")
public class User {
    
    @Id
	@Column(name = "cod_user", nullable = false)
    private Integer cod_user;

    @Column(name = "username", length = 32, nullable = false)
    private String username;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "email", length = 128, nullable = false)
    private String email;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Column(name = "creation_date", length = 3, nullable = false)
    private String creationdate;

    public User(Integer pk) {
        this.cod_user = pk;
    }
}
