package formation.kira.demo.repositories.elasticsearch;

import formation.kira.demo.models.FilmSearch;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Repository pour la recherche des films.
 * Il utilise El
 */
public interface FilmElasticsearchRepository extends ElasticsearchRepository<FilmSearch, String> {
    /**
     * Recherche les films ayant le mot clé dans leurs titre, description ou dans le nom ou prénom de leurs acteurs.
     * @param keyword mot clé a rechercher.
     * @return la liste des films.
     */
    @Query("{\"bool\":{\"should\":[{\"match\":{\"description\":{\"query\":\"?0\",\"boost\":1}}},{\"match\":{\"titre\":{\"query\":\"?0\",\"boost\":3}}},{\"match\":{\"acteurs.pseudo\":{\"query\":\"?0\",\"boost\":2}}}]}}")
    public List<FilmSearch> searchByKeyword(String keyword);
}
