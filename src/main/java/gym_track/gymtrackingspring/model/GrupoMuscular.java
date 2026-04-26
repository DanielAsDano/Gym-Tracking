package gym_track.gymtrackingspring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "grupos_musculares")
public class GrupoMuscular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_grupo_muscular;
    private String nombre_grupo_muscular;
}
