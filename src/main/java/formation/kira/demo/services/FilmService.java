package formation.kira.demo.services;

import formation.kira.demo.models.Film;
import formation.kira.demo.repositories.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private FilmRepository repository;

    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    /**
     * Retourne la liste de tout les films
     * @return les films sauvegardés
     */
    public List<Film> findAll() {
        return repository.findAll();
    }

    /**
     * Sauvegarde un nouveau film.
     * entity ne doit pas avoir d'id.
     * @param entity film a sauvegarder
     * @return l'entité avec un nouveau id
     */
    public Film insert(Film entity) {
        return repository.insert(entity);
    }

    /**
     * Sauvegarde ou met a jour un film.
     * Si le film ne posséde pas d'id, alors il est sauvegardé ({@see FilmService::insert}).
     * Sinon remplace la valeur sauvegarder par la nouvelle valeur.
     * @param entity nouveuu film ou film mit a jour.
     * @return l'entité identique a la version sauvegardé.
     */
    public Film save(Film entity) {
        return repository.save(entity);
    }

    /**
     * Recherche un film en fonction de son id.
     * Si l'id n'est pas valide, retourn un status 404.
     * @param id du film a rechercher
     * @return le film possédant cette id.
     */
    public Film findById(String id) {
        return repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Le film d'id "+id+" n'existe pas."));
    }

    /**
     * Supprime, s'il existe, le film en fonction de son id.
     * @param id du film a supprimé
     */
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
