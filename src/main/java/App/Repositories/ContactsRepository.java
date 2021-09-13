package App.Repositories;

import App.Entities.Contacts;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends PagingAndSortingRepository<Contacts, Long> {
}