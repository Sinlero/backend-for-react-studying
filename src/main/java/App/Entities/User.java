package App.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 255)
    @Column(unique = true)
    private String login;
    @NotBlank
    @Size(min = 5, max = 255)
    private String password;
    @NotBlank
    @Size(min = 2, max = 45)
    private String name;
    private String fullName;
    private String uniqueUrlName;
    private String photos;
    private String status;
    private String aboutMe;
    @OneToOne
    private Contacts contacts;
    private String lookingForAJobDescription;
    private Boolean lookingForAJob;
    private Boolean followed;
    @ManyToMany
    private List<Role> roles;
}
