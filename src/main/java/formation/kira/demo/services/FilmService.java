package formation.kira.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import formation.kira.demo.models.ActeurNested;
import formation.kira.demo.models.Award;
import formation.kira.demo.models.Film;
import formation.kira.demo.models.FilmSearch;
import formation.kira.demo.repositories.elasticsearch.FilmElasticsearchRepository;
import formation.kira.demo.repositories.mongo.FilmMongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmMongoRepository mongoRepository;
    private final FilmSearchService searchService;

    public FilmService(FilmMongoRepository mongoRepository, FilmSearchService searchService) {
        this.mongoRepository = mongoRepository;
        this.searchService = searchService;
    }

    /**
     * Retourne la liste de tout les films
     *
     * @return les films sauvegardés
     */
    public List<Film> findAll() {
        return mongoRepository.findAll();
    }

    /**
     * Sauvegarde un nouveau film.
     * entity ne doit pas avoir d'id.
     *
     * @param entity film a sauvegarder
     * @return l'entité avec un nouveau id
     */
    public Film insert(Film entity) {
        String newId = mongoRepository.insert(entity).getId();
        Film film = this.findById(newId);
        searchService.saveSearch(film);
        return film;
    }



    /**
     * Sauvegarde ou met a jour un film.
     * Si le film ne posséde pas d'id, alors il est sauvegardé ({@see FilmService::insert}).
     * Sinon remplace la valeur sauvegarder par la nouvelle valeur.
     *
     * @param entity nouveuu film ou film mit a jour.
     * @return l'entité identique a la version sauvegardé.
     */
    public Film save(Film entity) {
        Film film = mongoRepository.save(entity);
        searchService.saveSearch(film);
        return film;
    }

    /**
     * Recherche un film en fonction de son id.
     * Si l'id n'est pas valide, retourn un status 404.
     *
     * @param id du film a rechercher
     * @return le film possédant cette id.
     */
    public Film findById(String id) {
        return mongoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Le film d'id " + id + " n'existe pas."));
    }

    /**
     * Supprime, s'il existe, le film en fonction de son id.
     *
     * @param id du film a supprimé
     */
    public void deleteById(String id) {
        mongoRepository.deleteById(id);
        searchService.deleteById(id);
    }

    /**
     * Retourne la liste des awards des films.
     *
     * @return liste des awards
     */
    public List<Award> findAllAward() {
        return mongoRepository.findDistinctAwardsByIdNotNull();
    }

    public Iterable<Film> search(String keyword){
        List<FilmSearch> filmSearches = this.searchService.searchByKeyword(keyword);
        List<String> ids = filmSearches.stream().map(FilmSearch::getId).collect(Collectors.toList());
        return this.mongoRepository.findAllById(ids);
    }


}
