package nl.novi.sowtheland.Repository;

import nl.novi.sowtheland.Model.Crop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends CrudRepository <Crop, Long> {
    Crop findByCropNameContainingIgnoreCase (String cropName);
}
