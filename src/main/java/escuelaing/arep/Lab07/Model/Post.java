package escuelaing.arep.Lab07.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue
    private UUID id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(optional = false)
    @JoinColumn(name = "stream_id")
    private Stream stream;


    @Column(nullable = false, length = 140)
    private String content;


    @Column(nullable = false)
    private Instant createdAt;
}
