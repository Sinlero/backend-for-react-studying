package App.Repositories;

import App.Entities.Contacts;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactsRepository extends PagingAndSortingRepository<Contacts, Long> {
}