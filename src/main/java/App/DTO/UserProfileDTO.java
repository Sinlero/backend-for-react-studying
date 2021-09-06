package App.DTO;

import App.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileDTO {

    private String name;
    private String fullName;
    private String uniqueUrlName;
    private String photos;
    private String aboutMe;
    private String lookingForAJobDescription;
    private Boolean lookingForAJob;
    private ContactsDTO contacts;

    public UserProfileDTO(User user) {
        name = user.getName();
        fullName =user.getFullName();
        uniqueUrlName = user.getUniqueUrlName();
        photos = user.getPhotos();
        aboutMe = user.getAboutMe();
        lookingForAJobDescription = user.getLookingForAJobDescription();
        lookingForAJob = user.getLookingForAJob();
        contacts = new ContactsDTO(user.getContacts());
    }

}
