package escuelaing.arep.Lab07.Service;


import escuelaing.arep.Lab07.Exception.NotFoundException;
import escuelaing.arep.Lab07.Model.User;
import escuelaing.arep.Lab07.Repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User user) {
        return userRepository.save(user);
    }


    public User getById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }


    public List<User> list() { return userRepository.findAll(); }
}