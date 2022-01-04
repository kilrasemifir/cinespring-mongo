package formation.kira.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    private String id;

    private String titre;
    private String description;
    private String dateSortie;
    private int duree;
}


