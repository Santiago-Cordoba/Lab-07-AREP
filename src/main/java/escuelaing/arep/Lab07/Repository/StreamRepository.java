package escuelaing.arep.Lab07.Repository;

import escuelaing.arep.Lab07.Model.Stream;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;


public interface StreamRepository extends JpaRepository<Stream, UUID> {
}