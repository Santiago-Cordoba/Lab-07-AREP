package escuelaing.arep.Lab07.Controller;

import escuelaing.arep.Lab07.DTO.CreateStreamRequest;
import escuelaing.arep.Lab07.Model.Stream;
import escuelaing.arep.Lab07.Service.StreamService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/streams")
public class StreamController {
    private final StreamService streamService;


    public StreamController(StreamService streamService) { this.streamService = streamService; }


    @PostMapping
    public ResponseEntity<Stream> create(@Validated @RequestBody CreateStreamRequest req) {
        Stream s = Stream.builder().name(req.getName()).description(req.getDescription()).build();
        Stream saved = streamService.create(s);
        return ResponseEntity.created(URI.create("/streams/" + saved.getId())).body(saved);
    }


    @GetMapping
    public ResponseEntity<List<Stream>> list() { return ResponseEntity.ok(streamService.list()); }


    @GetMapping("/{id}")
    public ResponseEntity<Stream> get(@PathVariable("id") java.util.UUID id) { return ResponseEntity.ok(streamService.getById(id)); }
}