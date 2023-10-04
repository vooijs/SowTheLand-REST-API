package nl.novi.sowtheland.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
@Data

@Entity
@Table (name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    private ArrayList <Crop> garden;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

}
