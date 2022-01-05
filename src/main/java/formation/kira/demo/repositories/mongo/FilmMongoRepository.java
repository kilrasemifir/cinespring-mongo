package formation.kira.demo.repositories.mongo;

import formation.kira.demo.models.Award;
import formation.kira.demo.models.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilmMongoRepository extends MongoRepository<Film, String> {

    public List<Award> findDistinctAwardsByIdNotNull();

    public List<Film> findAllByTitre(String titre);

    public List<Film> findAllByTitreLike(String titre);

    public List<Film> findAllByTitreRegex(String regex);
}
