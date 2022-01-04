package formation.kira.demo.services;

import formation.kira.demo.models.Seance;
import formation.kira.demo.repositories.SeanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {

    private SeanceRepository repository;

    public SeanceService(SeanceRepository repository) {
        this.repository = repository;
    }

    public List<Seance> findAll() {
        return repository.findAll();
    }
    /**
     * Sauvegarde une nouvelle seance.
     * entity ne doit pas avoir d'id.
     * @param entity seance a sauvegarder
     * @return l'entité avec un nouveau id
     */
    public Seance insert(Seance entity) {
        return repository.insert(entity);
    }
    /**
     * Sauvegarde ou met a jour une seance.
     * Si la seance ne posséde pas d'id, alors il est sauvegardé ({@see SeanceService::insert}).
     * Sinon remplace la valeur sauvegarder par la nouvelle valeur.
     * @param entity nouvelle seance.
     * @return l'entité identique a la version sauvegardé.
     */
    public Seance save(Seance entity) {
        return repository.save(entity);
    }

    public Seance findById(String id) {
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "La seance d'id"+id+"n'existe aps"));
    }

    public void deleteById(String s) {
        repository.deleteById(s);
    }
}
