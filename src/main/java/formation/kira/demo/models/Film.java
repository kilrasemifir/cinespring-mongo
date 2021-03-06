package formation.kira.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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
    @DBRef
    private List<Acteur> acteurs = new ArrayList<>();
    private List<Award> awards = new ArrayList<>();
}


