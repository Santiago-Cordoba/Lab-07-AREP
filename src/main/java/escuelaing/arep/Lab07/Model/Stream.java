package escuelaing.arep.Lab07.Model;

import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;


@Entity
@Table(name = "streams")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stream {
    @Id
    @GeneratedValue
    private UUID id;


    @Column(nullable = false)
    private String name;


    private String description;
}
