package nl.novi.sowtheland.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data


@Entity
@Table (name = "Crops")
public class Crop {

    @Id
    @GeneratedValue
    private Long cropId;
    private String cropName;
    private String cropType;
    private String position;
    private LocalDate beginPlantingPeriod;
    private LocalDate endPlantingPeriod;
    private int watering;

    @ManyToOne
    private User user;


}
