package nl.novi.sowtheland.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Crops")
public class Crop {

    @Id
    @GeneratedValue
    private Long cropId;
    private String cropName;
    private String cropType;
    private String description;

    @ManyToOne
    private Garden garden;
    public Long getCropId() {
        return cropId;
    }

    public void setCropId(Long cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }
}
