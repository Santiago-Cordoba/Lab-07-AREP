package escuelaing.arep.Lab07.Repository;

import escuelaing.arep.Lab07.Model.Post;
import escuelaing.arep.Lab07.Model.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;


public interface PostRepository extends JpaRepository<Post, UUID> {
    Page<Post> findByStreamIdOrderByCreatedAtDesc(UUID streamId, Pageable pageable);
    Page<Post> findByUserIdOrderByCreatedAtDesc(UUID userId, Pageable pageable);
    List<Post> findByStreamOrderByCreatedAtDesc(Stream stream);
}