package nl.novi.sowtheland.Repository;

import nl.novi.sowtheland.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository <Role, String>{
}
