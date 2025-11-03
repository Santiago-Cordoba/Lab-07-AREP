package escuelaing.arep.Lab07.DTO;

import lombok.*;

import java.util.UUID;


public class CreatePostRequest {
    private UUID userId;
    private UUID streamId;
    private String content;

    public CreatePostRequest(UUID userId, UUID streamId, String content) {
        this.userId = userId;
        this.streamId = streamId;
        this.content = content;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getStreamId() {
        return streamId;
    }

    public void setStreamId(UUID streamId) {
        this.streamId = streamId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
