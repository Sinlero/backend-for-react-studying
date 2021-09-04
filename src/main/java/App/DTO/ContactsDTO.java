package App.DTO;

import App.Entities.Contacts;
import lombok.Data;

@Data
public class ContactsDTO {

    private String facebook;
    private String website;
    private String vk;
    private String twitter;
    private String instagram;
    private String youtube;
    private String github;
    private String mainLink;

    public ContactsDTO(Contacts contacts) {
        facebook = contacts.getFacebook();
        website = contacts.getWebsite();
        vk = contacts.getVk();
        twitter = contacts.getTwitter();
        instagram = contacts.getInstagram();
        youtube = contacts.getYoutube();
        github = contacts.getGithub();
        mainLink = contacts.getMainLink();
    }
}
