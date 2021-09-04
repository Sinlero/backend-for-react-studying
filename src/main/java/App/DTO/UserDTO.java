package App.DTO;

import App.Entities.Contacts;
import App.Entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String status;
    private String photos;
    private Boolean followed;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        status = user.getStatus();
        photos = user.getPhotos();
        followed = user.getFollowed();
    }
}
