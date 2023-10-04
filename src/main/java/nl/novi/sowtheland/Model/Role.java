package nl.novi.sowtheland.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table (name = "roles")
public class Role {
    @Id
    private String rolename;
    @ManyToMany(mappedBy = "roles")
    public Collection<User> users;
}
