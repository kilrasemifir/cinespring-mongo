package formation.kira.demo.repositories.mongo;

import formation.kira.demo.models.Acteur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActeurMongoRepository extends MongoRepository<Acteur, String> {
}
