package escuelaing.arep.Lab07.Repository;

import escuelaing.arep.Lab07.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}