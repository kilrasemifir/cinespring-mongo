package formation.kira.demo.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Award {
    private String titre;
    private String description;
    private LocalDate date;
}
