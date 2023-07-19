package nl.novi.sowtheland.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "gardens")
public class Garden {
    @Id
    @GeneratedValue
    private Long gardenId;
    private int gardenSize;
    @OneToOne (cascade = CascadeType.ALL)
    private User user;
    @OneToMany (mappedBy = "garden")

    private List<Crop> crops;

    public Long getGardenId() {
        return gardenId;
    }

    public void setGardenId(Long gardenId) {
        this.gardenId = gardenId;
    }

    public int getGardenSize() {
        return gardenSize;
    }

    public void setGardenSize(int gardenSize) {
        this.gardenSize = gardenSize;
    }
}
