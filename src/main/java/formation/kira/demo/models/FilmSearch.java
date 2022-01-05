package formation.kira.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(indexName = "film")
@AllArgsConstructor
@NoArgsConstructor
public class FilmSearch {
    @Id
    private String id;
    private String titre;
    private String description;
    private List<ActeurNested> acteurs;
    private List<Award> awards;
    private int duree;
}
