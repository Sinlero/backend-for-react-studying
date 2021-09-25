package App.Services;

import App.DTO.UserDTO;
import App.DTO.UserProfileDTO;
import App.DTO.UsersDTO;
import App.Entities.Contacts;
import App.Entities.User;
import App.Exceptions.UserNotFoundException;
import App.Repositories.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersDTO getUsers(int page, int limit) {
        Page<User> users = usersRepository.findAll(PageRequest.of(--page, limit, Sort.by("id")));
        return new UsersDTO(new ArrayList<>(users.getContent().stream().map(UserDTO::new).collect(Collectors.toList())), users.getTotalElements(), users.getTotalPages());
    }

    public UserProfileDTO getProfile(Long id) {
        User user = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        if (user.getContacts() == null) {
            user.setContacts(new Contacts(null, "", "", "", "", "", "", "", ""));
        }
        return new UserProfileDTO(user);
    }

    public User getByLogin(String login) {
        return usersRepository.findUserByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with login '%s' not found", login)));
    }
}
