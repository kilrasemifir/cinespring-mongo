package formation.kira.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import formation.kira.demo.models.ActeurNested;
import formation.kira.demo.models.Film;
import formation.kira.demo.models.FilmSearch;
import formation.kira.demo.repositories.elasticsearch.FilmElasticsearchRepository;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmSearchService {
    private final FilmElasticsearchRepository elasticsearchRepository;
    private final ObjectMapper mapper;

    public FilmSearchService(FilmElasticsearchRepository elasticsearchRepository, ObjectMapper mapper) {
        this.elasticsearchRepository = elasticsearchRepository;
        this.mapper = mapper;
    }

    /**
     * Met en forme et sauvegarde un film pour les futures recherches.
     * @param film a sauvegarder.
     */
    public void saveSearch(Film film) {
        FilmSearch filmSearch = convertToSearch(film);
        elasticsearchRepository.save(filmSearch);
    }

    private FilmSearch convertToSearch(Film film) {
        FilmSearch filmSearch = mapper.convertValue(film, FilmSearch.class);
        filmSearch.setActeurs(new ArrayList<>());
        film.getActeurs().forEach(acteur -> filmSearch.getActeurs().add(
                new ActeurNested(
                        acteur.getNom() + " " + acteur.getPrenom(), acteur.getAwards())));
        return filmSearch;
    }

    /**
     * Supprimer les données permettant la recherche d'un film.
     * @param id du film a supprimer.
     */
    public void deleteById(String id) {
        elasticsearchRepository.deleteById(id);
    }

    /**
     * Recherche un film en fonction d'un mot clé.
     * Le mot clé peut etre dans la description, le titre ou dans le pseudonyme d'un acteur.
     * @param keyword mot clé
     * @return la liste des films
     */
    public List<FilmSearch> searchByKeyword(String keyword) {
        return elasticsearchRepository.searchByKeyword(keyword);
    }
}
