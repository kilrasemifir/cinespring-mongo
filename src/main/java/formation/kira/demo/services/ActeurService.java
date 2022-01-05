package formation.kira.demo.services;

import formation.kira.demo.models.Acteur;
import formation.kira.demo.repositories.mongo.ActeurMongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActeurService {


    private ActeurMongoRepository repository;

    public ActeurService(ActeurMongoRepository repository) {
        this.repository = repository;
    }

    public List<Acteur> findAll() {
        return repository.findAll();
    }

    public Acteur insert(Acteur entity) {
        return repository.insert(entity);
    }

    public Acteur save(Acteur entity) {
        return repository.save(entity);
    }

    public Acteur findById(String id) {
        return repository.findById(id)
                .orElseThrow(()-> {
                    final String reason = "L'acteur d'id " + id + " n'existe pas";
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, reason);
                });
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
