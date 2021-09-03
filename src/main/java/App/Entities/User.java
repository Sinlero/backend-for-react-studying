package App.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
}
