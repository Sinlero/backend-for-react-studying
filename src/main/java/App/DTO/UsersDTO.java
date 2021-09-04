package App.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDTO {

    List<UserDTO> users;
    Long totalRecords;
    int totalPages;

}