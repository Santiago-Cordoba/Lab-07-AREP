package escuelaing.arep.Lab07.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStreamRequest {
    private String name;
    private String description;
}
