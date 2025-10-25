package escuelaing.arep.Lab07.Service;

import escuelaing.arep.Lab07.Exception.NotFoundException;
import escuelaing.arep.Lab07.Model.Stream;
import escuelaing.arep.Lab07.Repository.StreamRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
public class StreamService {
    private final StreamRepository streamRepository;


    public StreamService(StreamRepository streamRepository) {
        this.streamRepository = streamRepository;
    }


    public Stream create(Stream s) { return streamRepository.save(s); }


    public Stream getById(UUID id) { return streamRepository.findById(id).orElseThrow(() -> new NotFoundException("Stream not found")); }


    public List<Stream> list() { return streamRepository.findAll(); }
}