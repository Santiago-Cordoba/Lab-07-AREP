package escuelaing.arep.Lab07.Service;

import escuelaing.arep.Lab07.Exception.NotFoundException;
import escuelaing.arep.Lab07.Model.Post;
import escuelaing.arep.Lab07.Model.Stream;
import escuelaing.arep.Lab07.Model.User;
import escuelaing.arep.Lab07.Repository.PostRepository;
import escuelaing.arep.Lab07.Repository.StreamRepository;
import escuelaing.arep.Lab07.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;
import java.util.UUID;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StreamRepository streamRepository;


    public PostService(PostRepository postRepository, UserRepository userRepository, StreamRepository streamRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.streamRepository = streamRepository;
    }


    public Post create(UUID userId, UUID streamId, String content) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        Stream stream = streamRepository.findById(streamId).orElseThrow(() -> new NotFoundException("Stream not found"));


        Post p = Post.builder()
                .user(user)
                .stream(stream)
                .content(content)
                .createdAt(Instant.now())
                .build();
        return postRepository.save(p);
    }


    public Page<Post> list(UUID streamId, UUID userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (streamId != null) return postRepository.findByStreamIdOrderByCreatedAtDesc(streamId, pageable);
        if (userId != null) return postRepository.findByUserIdOrderByCreatedAtDesc(userId, pageable);
        return postRepository.findAll(pageable);
    }


    public List<Post> listByStream(UUID streamId) {
        Stream stream = streamRepository.findById(streamId).orElseThrow(() -> new NotFoundException("Stream not found"));
        return postRepository.findByStreamOrderByCreatedAtDesc(stream);
    }


    public Post getById(UUID id) { return postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found")); }
}
