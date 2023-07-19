package nl.novi.sowtheland.Repository;

import nl.novi.sowtheland.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
    User findUserByEmail (String email);
}
