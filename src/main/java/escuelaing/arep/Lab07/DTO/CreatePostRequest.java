package escuelaing.arep.Lab07.DTO;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePostRequest {
    private UUID userId;
    private UUID streamId;
    private String content;
}
