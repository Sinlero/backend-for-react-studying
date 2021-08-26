package App.Repositories;

import App.Entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsersRepository extends PagingAndSortingRepository<User, Long> {

}
