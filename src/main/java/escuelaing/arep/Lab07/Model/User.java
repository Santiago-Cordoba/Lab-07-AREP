package escuelaing.arep.Lab07.Model;

import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;


@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private UUID id;


    @Column(nullable = false)
    private String name;


    @Column(nullable = false, unique = true)
    private String username;


    @Column(nullable = false)
    private String email;
}
