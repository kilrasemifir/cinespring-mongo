package formation.kira.demo.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActeurNested {
    private String pseudo;
    private List<Award> awards = new ArrayList<>();

}
