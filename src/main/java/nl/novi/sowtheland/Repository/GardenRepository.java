package nl.novi.sowtheland.Repository;

import nl.novi.sowtheland.Model.Garden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepository extends CrudRepository <Garden, Long> {
}
