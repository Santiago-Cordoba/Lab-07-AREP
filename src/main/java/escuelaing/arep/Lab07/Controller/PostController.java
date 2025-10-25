package escuelaing.arep.Lab07.Controller;

import escuelaing.arep.Lab07.DTO.CreatePostRequest;
import escuelaing.arep.Lab07.Model.Post;
import escuelaing.arep.Lab07.Service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) { this.postService = postService; }


    @PostMapping
    public ResponseEntity<Post> create(@Validated @RequestBody CreatePostRequest req) {
        Post p = postService.create(req.getUserId(), req.getStreamId(), req.getContent());
        return ResponseEntity.created(URI.create("/posts/" + p.getId())).body(p);
    }


    @GetMapping
    public ResponseEntity<org.springframework.data.domain.Page<Post>> list(
            @RequestParam(required = false) UUID streamId,
            @RequestParam(required = false) UUID userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(postService.list(streamId, userId, page, size));
    }


    @GetMapping("/stream/{streamId}")
    public ResponseEntity<List<Post>> listByStream(@PathVariable UUID streamId) { return ResponseEntity.ok(postService.listByStream(streamId)); }


    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable UUID id) { return ResponseEntity.ok(postService.getById(id)); }
}