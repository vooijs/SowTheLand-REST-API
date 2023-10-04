package nl.novi.sowtheland.Repository;

import nl.novi.sowtheland.Model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BlogRepository extends CrudRepository <Blog, Long> {
}
