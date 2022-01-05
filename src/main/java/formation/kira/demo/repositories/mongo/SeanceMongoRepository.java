package formation.kira.demo.repositories.mongo;

import formation.kira.demo.models.Seance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeanceMongoRepository extends MongoRepository<Seance, String> {
}
