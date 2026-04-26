package gym_track.gymtrackingspring.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "registros")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_registro;
    private Double peso;
    private Integer repeticiones;
    private  Integer id_ejercicio;
}
