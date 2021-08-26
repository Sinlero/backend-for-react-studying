package App.Services;

import App.DTO.UsersDTO;
import App.Entities.User;
import App.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersDTO getUsers(int page, int limit) {
        Page<User> users = usersRepository.findAll(PageRequest.of(--page, limit, Sort.by("id")));
        return new UsersDTO(users.getContent(), users.getTotalElements(), users.getTotalPages());
    }
}
