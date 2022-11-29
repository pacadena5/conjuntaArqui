package conjunta.espe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import conjunta.espe.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    List<User> findBycod_user(Integer code);
}
