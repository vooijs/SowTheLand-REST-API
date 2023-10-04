package nl.novi.sowtheland.Dto;

import jakarta.persistence.ManyToOne;
import nl.novi.sowtheland.Model.User;

import java.time.LocalDate;

public class CropDto {
    public Long cropId;
    public String cropName;
    public String cropType;
    public String position;
    public LocalDate beginPlantingPeriod;
    public LocalDate endPlantingPeriod;
    public int watering;

    @ManyToOne
    public User user;


}
