package App.DTO;

import App.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDTO {

    List<User> users;
    Long totalRecords;
    int totalPages;

}