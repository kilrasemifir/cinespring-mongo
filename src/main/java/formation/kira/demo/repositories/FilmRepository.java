package formation.kira.demo.repositories;

import formation.kira.demo.models.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmRepository extends MongoRepository<Film, String> {
}
