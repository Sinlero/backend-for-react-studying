package App.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne(mappedBy = "contacts")
    private User user;
    private String facebook;
    private String website;
    private String vk;
    private String twitter;
    private String instagram;
    private String youtube;
    private String github;
    private String mainLink;
}
